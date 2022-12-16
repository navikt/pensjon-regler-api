package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.beregning2011.AbstraktBeregningsResultat;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class VilkarsprovAlderspensjonResultat extends AbstraktVilkarsprovResultat {


    private AbstraktBeregningsResultat beregningVedUttak;
    private VilkarsprovInformasjon vilkarsprovInformasjon;

}
