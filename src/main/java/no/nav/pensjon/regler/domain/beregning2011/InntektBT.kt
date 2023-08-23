package no.nav.pensjon.regler.domain.beregning2011

import java.io.Serializable

class InntektBT : Serializable {
    /** Ny forventet inntekt  */
    var samletForventetInntekt = 0

    /** Detaljer rundt søkers andel av ny forventet inntekt.  */
    var soker: BeregnetInntekt? = null

    /** Detaljer rundt eps andel av ny forventet inntekt.  */
    var eps: BeregnetInntekt? = null

}