package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.beregning.Beregning

class VilkarsprovAlderspensjon67Resultat : AbstraktVilkarsprovResultat() {
    var beregningVedUttak: Beregning? = null
    var halvMinstePensjon = 0

}