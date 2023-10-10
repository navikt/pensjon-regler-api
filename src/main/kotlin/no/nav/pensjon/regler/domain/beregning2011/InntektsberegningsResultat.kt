package no.nav.pensjon.regler.domain.beregning2011

import java.io.Serializable

class InntektsberegningsResultat : Serializable {
    /** Ny forventet inntekt for TSB.  */
    var inntektTSB: InntektBT? = null

    /** Ny forventet inntekt for TFB.  */
    var inntektTFB: InntektBT? = null

}