package no.nav.domain.pensjon.regler.grunnlag;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Beholdninger implements Serializable {


    /**
     * property change variabler
     */
    private transient PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private static final HashMap<Class<?>, String> properties = finnProperties();

    private List<Beholdning> beholdninger = new ArrayList<Beholdning>();

    public Beholdninger() {
        super();
        pcs = new PropertyChangeSupport(this);
    }

    public Beholdninger(Beholdninger br) {
        this();
        if (br.beholdninger != null) {
            for (Beholdning b : br.beholdninger) {
                Class<? extends Beholdning> clazz = b.getClass();
                try {
                    Constructor<? extends Beholdning> constructor = clazz.getConstructor(new Class[] {clazz});
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
        pcs = new PropertyChangeSupport(this);
        return this;
    }

    /**
     * Legger en listener til registeret av lyttere
     * 
     * @param listener
     */
    public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    /**
     * Fjerner en listener i registeret for lyttere
     * 
     * @param listener
     */
    public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    public void leggTilBeholdning(Beholdning b) {
        Beholdning lagret = hentBeholdning(b.getClass());
        if (lagret != null) {
            beholdninger.remove(lagret);
        }
        beholdninger.add(b);

        if (properties.containsKey(b.getClass())) {
            // Vi må fyre en property changed event slik at Blaze skal oppfatte at en gitt property skal oppdateres
            pcs.firePropertyChange(properties.get(b.getClass()), lagret, b);
            pcs.firePropertyChange("beholdninger", null, null);
            pcs.firePropertyChange("beholdningerAsArray", null, null);
        }
    }

    public void fjernBeholdning(Beholdning b) {
        fjernBeholdning(b.getClass());
    }

    public void fjernAlleBeholdninger() {
        List<Beholdning> old = beholdninger;
        beholdninger.clear();
        for (Class<?> clazz : properties.keySet()) {
            pcs.firePropertyChange(properties.get(clazz), old, null);
        }
        pcs.firePropertyChange("beholdninger", null, null);
        pcs.firePropertyChange("beholdningerAsArray", null, null);
    }

    public List<Beholdning> getBeholdninger() {
        return beholdninger;
    }

    public Beholdning[] getBeholdningerAsArray() {
        return beholdninger != null ? beholdninger.toArray(new Beholdning[beholdninger.size()]) : new Beholdning[0];
    }

    public void setBeholdninger(List<Beholdning> beholdninger) {
        List<Beholdning> old = beholdninger;
        this.beholdninger = beholdninger;
        pcs.firePropertyChange("beholdningerAsArray", old, beholdninger);
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
     * 
     * @param y
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
            if (properties.containsKey(clazz)) {
                // Vi må fyre en property changed event slik at Blaze skal oppfatte at en gitt property skal oppdateres
                pcs.firePropertyChange(properties.get(clazz), tmpBeholdning, null);
                //Fungerte ikke
                pcs.firePropertyChange("beholdninger", null, null);
                pcs.firePropertyChange("beholdningerAsArray", null, null);
            }
        }
    }

    /**
     * Metode som endrer forste bokstav til lowecase
     * 
     * @param string
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
     * 
     * @throws InstantiationException
     * @throws IllegalAccessException
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
                    if (propertyName.toLowerCase().equals(clazz.getSimpleName().toLowerCase())) {
                        properties.put(clazz, forbokstavTilLowercase(propertyName));
                    }
                }
                superclass = superclass.getSuperclass();
            }
        }

        return properties;
    }

}
