package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.beregning2011.AbstraktBeregningsResultat;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class VilkarsprovAlderspensjonResultat extends AbstraktVilkarsprovResultat {


    private AbstraktBeregningsResultat beregningVedUttak;
    private VilkarsprovInformasjon vilkarsprovInformasjon;

    public VilkarsprovAlderspensjonResultat() {
        super();
    }

    public VilkarsprovAlderspensjonResultat(VilkarsprovAlderspensjonResultat r) {
        this();
        if (r.beregningVedUttak != null) {
            Class<? extends AbstraktBeregningsResultat> clazz = r.beregningVedUttak.getClass();
            try {
                Constructor<? extends AbstraktBeregningsResultat> constructor = clazz.getConstructor(new Class[] {clazz});
                beregningVedUttak = constructor.newInstance(r.beregningVedUttak);
                // System.out.println("VilkarsprovAlderspensjonResultat copy constructor "
                // + this.beregningVedUttak);
            } catch (InvocationTargetException e) {
                // Vil kastes hvis copy constructor f.eks. ledet til
                // nullpointerexception.
                Throwable cause = e.getCause();
                if (cause instanceof RuntimeException) {
                    throw (RuntimeException) cause;
                } else {
                    throw new RuntimeException(e);
                }
            } catch (Exception e) {
                // Vil kastes hvis f.eks. copy constructor ikke finnes.
                throw new RuntimeException(e);
            }
            if (r.vilkarsprovInformasjon != null) {
                Class<? extends VilkarsprovInformasjon> vilkarsprovInfoClazz = r.vilkarsprovInformasjon.getClass();
                try {
                    Constructor<? extends VilkarsprovInformasjon> vilkarsprovInfoConstructor = vilkarsprovInfoClazz.getConstructor(new Class[] {vilkarsprovInfoClazz});
                    vilkarsprovInformasjon = vilkarsprovInfoConstructor.newInstance(r.vilkarsprovInformasjon);
                } catch (InvocationTargetException e) {
                    Throwable cause = e.getCause();
                    if (cause instanceof RuntimeException) {
                        throw (RuntimeException) cause;
                    } else {
                        throw new RuntimeException(e);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            // this.vilkarsprovInformasjon = new VilkarsprovInformasjon(r.vilkarsprovInformasjon);
        }
    }

    public AbstraktBeregningsResultat getBeregningVedUttak() {
        return beregningVedUttak;
    }

    public void setBeregningVedUttak(AbstraktBeregningsResultat beregningVedUttak) {
        this.beregningVedUttak = beregningVedUttak;
    }

    public VilkarsprovInformasjon getVilkarsprovInformasjon() {
        return vilkarsprovInformasjon;
    }

    public void setVilkarsprovInformasjon(VilkarsprovInformasjon vilkarsprovInformasjon) {
        this.vilkarsprovInformasjon = vilkarsprovInformasjon;
    }
}
