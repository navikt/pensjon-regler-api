package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.kode.JusteringsTypeCti;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class JusteringsInformasjon implements Serializable {
    private static final long serialVersionUID = 2474123061927464485L;

    private double totalJusteringsfaktor;
    private JusteringsTypeCti justeringsTypeCti;
    private List<IJustering> elementer;

    public JusteringsInformasjon() {
        super();
        elementer = new ArrayList<IJustering>();
    }

    public JusteringsInformasjon(JusteringsInformasjon ji) {
        this();
        totalJusteringsfaktor = ji.totalJusteringsfaktor;
        if (ji.justeringsTypeCti != null) {
            justeringsTypeCti = new JusteringsTypeCti(ji.getJusteringsTypeCti());
        }
        if (ji.elementer != null) {
            for (IJustering ij : ji.elementer) {
                Class<? extends IJustering> clazz = ij.getClass();
                try {
                    Constructor<?> constructor = clazz.getConstructor(new Class[] {clazz});
                    elementer.add((IJustering) constructor.newInstance(ij));
                } catch (InvocationTargetException e) {
                    //Vil kastes hvis copy constructor f.eks. ledet til nullpointerexception.
                    Throwable cause = e.getCause();
                    if (cause instanceof RuntimeException) {
                        throw (RuntimeException) cause;
                    } else {
                        throw new RuntimeException(e);
                    }
                } catch (Exception e) {
                    //Vil kastes hvis f.eks. copy constructor ikke finnes for komponenten.
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public JusteringsTypeCti getJusteringsTypeCti() {
        return justeringsTypeCti;
    }

    public void setJusteringsTypeCti(JusteringsTypeCti justeringsTypeCti) {
        this.justeringsTypeCti = justeringsTypeCti;
    }

    public double getTotalJusteringsfaktor() {
        return totalJusteringsfaktor;
    }

    public void setTotalJusteringsfaktor(double totalJusteringsfaktor) {
        this.totalJusteringsfaktor = totalJusteringsfaktor;
    }

    public List<IJustering> getElementer() {
        return elementer;
    }

    public void setElementer(List<IJustering> elementer) {
        this.elementer = elementer;
    }
}
