package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.BeregningsresultatUforetrygd

class InntektsavkortningUforetrygdResponse : ServiceResponse() {
    /**
     * Beregningsresultat med ny inntektsavkortning.
     */
    var beregningsresultatUforetrygd: BeregningsresultatUforetrygd? = null
}