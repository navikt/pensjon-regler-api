package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat

class VilkarsprovAlderspensjonResultat : AbstraktVilkarsprovResultat() {
    var beregningVedUttak: AbstraktBeregningsResultat? = null
    var vilkarsprovInformasjon: VilkarsprovInformasjon? = null
}