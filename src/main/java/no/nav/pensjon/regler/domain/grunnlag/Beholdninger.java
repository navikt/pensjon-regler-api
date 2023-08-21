package no.nav.pensjon.regler.domain.grunnlag;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Beholdninger implements Serializable {
    private static final long serialVersionUID = -3795813899633856402L;

    /**
     * property change variabler
     */
    private static final HashMap<Class<?>, String> properties = finnProperties();

    private List<Beholdning> beholdninger = new ArrayList<Beholdning>();

    public Beholdninger() {
        super();
    }

    public Beholdninger(Beholdninger br) {
        this();
        if (br.beholdninger != null) {
            for (Beholdning b : br.beholdninger) {
                Class<? extends Beholdning> clazz = b.getClass();
                try {
                    Constructor<? extends Beholdning> constructor = clazz.getConstructor(clazz);
                    beholdninger.add(constructor.newInstance(b));
                } catch (InvocationTargetException e) {
                    //Vil kastes hvis copy constructor f.eks. ledet til nullpointerexception.
                    Throwable cause = e.getCause();
                    if (cause instanceof RuntimeException) {
                        throw (RuntimeException) cause;
                    } else {
                        throw new RuntimeException(e);
                    }
                } catch (Exception e) {
                    //Vil kastes hvis f.eks. copy constructor ikke finnes for beholdningen.
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * Metode som benyttes av XStream og Java-serialisering for å
     * initialisere felt vi hopper over p.g.a sykliske avhengigheter.
     */
    private Object readResolve() throws ObjectStreamException {
        return this;
    }

    public void leggTilBeholdning(Beholdning b) {
        Beholdning lagret = hentBeholdning(b.getClass());
        if (lagret != null) {
            beholdninger.remove(lagret);
        }
        beholdninger.add(b);
    }

    public void fjernBeholdning(Beholdning b) {
        fjernBeholdning(b.getClass());
    }

    public void fjernAlleBeholdninger() {
        List<Beholdning> old = beholdninger;
        beholdninger.clear();
    }

    public List<Beholdning> getBeholdninger() {
        return beholdninger;
    }

    public void setBeholdninger(List<Beholdning> beholdninger) {
        List<Beholdning> old = beholdninger;
        this.beholdninger = beholdninger;
    }

    public Pensjonsbeholdning getPensjonsbeholdning() {
        return hentBeholdning(Pensjonsbeholdning.class);
    }

    public void setPensjonsbeholdning(Pensjonsbeholdning pensjonsbeholdning) {
        fjernEllerLeggTilBeholdning(Pensjonsbeholdning.class, pensjonsbeholdning);
    }

    public Garantipensjonsbeholdning getGarantipensjonsbeholdning() {
        return hentBeholdning(Garantipensjonsbeholdning.class);
    }

    public void setGarantipensjonsbeholdning(Garantipensjonsbeholdning garantipensjonsbeholdning) {
        fjernEllerLeggTilBeholdning(Garantipensjonsbeholdning.class, garantipensjonsbeholdning);
    }

    public Garantitilleggsbeholdning getGarantitilleggsbeholdning() {
        return hentBeholdning(Garantitilleggsbeholdning.class);
    }

    public void setGarantitilleggsbeholdning(Garantitilleggsbeholdning garantitilleggsbeholdning) {
        fjernEllerLeggTilBeholdning(Garantitilleggsbeholdning.class, garantitilleggsbeholdning);
    }

    /**
     * @param <T>
     * @param classOfBeholdning, angir klassen til beholdningen man ønsker å hente
     * @return Beholdning av ønsket type
     */
    @SuppressWarnings("unchecked")
    public <T extends Beholdning> T hentBeholdning(Class<T> classOfBeholdning) {
        for (Beholdning b : beholdninger) {
            if (classOfBeholdning.isInstance(b)) {
                return (T) b;
            }
        }
        return null;
    }

    /**
     * Fjerner en beholdning, null safe
     */
    private void fjernEllerLeggTilBeholdning(Class<? extends Beholdning> clazz, Beholdning b) {
        if (b == null) {
            fjernBeholdning(clazz);
        } else {
            leggTilBeholdning(b);
        }
    }

    /**
     * Fjerner en beholdning og oppdaterer properties ved å fyre av en property changed event
     *
     * @param clazz
     */
    private void fjernBeholdning(Class<? extends Beholdning> clazz) {
        boolean funnet = false;
        Beholdning tmpBeholdning = null;
        for (Beholdning beholdning : beholdninger) {
            if (beholdning.getClass().equals(clazz)) {
                funnet = true;
                tmpBeholdning = beholdning;
            }
        }
        if (funnet) {
            beholdninger.remove(tmpBeholdning);
        }
    }

    /**
     * Metode som endrer forste bokstav til lowecase
     *
     * @return string
     */
    private static String forbokstavTilLowercase(String input) {
        String forsteBokstav = input.substring(0, 1);
        String resten = input.substring(1);

        return forsteBokstav.toLowerCase() + resten;
    }

    /**
     * Metode som finner properties for beholdninger
     * og legger dem i hashmap
     */
    protected static HashMap<Class<?>, String> finnProperties() {
        HashMap<Class<?>, String> properties = new HashMap<Class<?>, String>();
        Method[] methods = Beholdninger.class.getDeclaredMethods();
        for (Method method : methods) {
            Class<?> clazz = method.getReturnType();
            Class<?> superclass = null;
            if (clazz != null) {
                superclass = clazz.getSuperclass();
            }
            while (superclass != null) {
                if (superclass != null && superclass.equals(Beholdning.class)) {
                    String propertyName = method.getName().substring(3);
                    if (propertyName.equalsIgnoreCase(clazz.getSimpleName())) {
                        properties.put(clazz, forbokstavTilLowercase(propertyName));
                    }
                }
                superclass = superclass.getSuperclass();
            }
        }

        return properties;
    }

}
