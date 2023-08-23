package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning2011.BeregningsresultatUforetrygd
import java.io.Serializable

class InntektsavkortningUforetrygdResponse : Serializable {
    /**
     * Beregningsresultat med ny inntektsavkortning.
     */
    var beregningsresultatUforetrygd: BeregningsresultatUforetrygd? = null

    /**
     * Pakkseddel
     */
    var pakkseddel: Pakkseddel? = null
}