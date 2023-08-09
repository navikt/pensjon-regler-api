package no.nav.domain.pensjon.regler.util;

import no.nav.domain.pensjon.regler.beregning2011.BeregningsvilkarPeriode;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ListUtil {

    /**
     * Returnerer {@link no.nav.domain.pensjon.regler.beregning2011.BeregningsvilkarPeriode} som gjelder på dato.
     * Forventer at det ikke er overlapp i listen.
     */
    public static BeregningsvilkarPeriode finnGjeldendeBeregningsvilkaarPeriodePaaDato(List<BeregningsvilkarPeriode> beregningsvilkarPeriodeListe, Date dato) {
        if (beregningsvilkarPeriodeListe != null) {
            for (BeregningsvilkarPeriode bvp : beregningsvilkarPeriodeListe) {
                if (DateUtil.isDateInPeriod(dato, bvp.getFomDato(), bvp.getTomDato())) {
                    return bvp;
                }
            }
        }

        return null;
    }

    /**
     * A way to copy all the elements of a list by calling the constructor of the class of whatever object is contained within the list.
     * E.g. If the list contains Ytelseskomponenter, then the specific copyconstructor for Grunnpensjon, Tilleggspensjon,
     * etc will be called, and thus all properties will be copied.
     * Originally made to copy the six lists in InntektKontrollGrunnlag in PK-25612.
     * According to our coding standard, every PREG class should have a copy constructor. If this is not the case, then this method will fail.
     *
     * @param listToCopy A list containing any class
     * @return An new list containing actual copies, not just copied references, of the objects in the listToCopy
     */
    public static <A> List<A> deepCopyReflection(List<A> listToCopy) {
        List<A> copyOfList = new ArrayList<A>();
        for (A a : listToCopy) {
            try {
                copyOfList.add((A) Class.forName(a.getClass().getName()).getConstructor(a.getClass()).newInstance(a));
            } catch (IllegalArgumentException e) {
            } catch (SecurityException e) {
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            } catch (NoSuchMethodException e) {
            } catch (ClassNotFoundException e) {
            }
        }
        return copyOfList;
    }

    public static <A extends Copyable<A>> List<A> deepCopyList(List<A> listToCopy) {
        List<A> copyOfList = new ArrayList<A>();
        for (A a : listToCopy) {
            copyOfList.add(a.deepCopy());
        }
        return copyOfList;
    }
}
