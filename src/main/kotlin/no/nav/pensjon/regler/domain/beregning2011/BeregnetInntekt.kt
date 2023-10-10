package no.nav.pensjon.regler.domain.beregning2011

import java.io.Serializable

class BeregnetInntekt : Serializable {
    /** Sum av ytelse og andre inntekter for relevant bruker.  */
    var forventetInntekt = 0

    /** Faktisk utbetalt ytelse og fremskrevet ytelse fra folketrygden ved virk
     * som inngår i avkortning av barnetillegg.  */
    var ytelseFolketrygd = 0.0

    /** Faktisk utbetalt ytelse og fremskrevet ytelse som ikke er en del av folketrygden
     * ved virk som inngår i avkortning av barnetillegg. Feks. AFP privat   */
    var ytelseIkkeFolketrygd = 0.0

    /** Sum av relevante inntekter fra inntektskomponenten.  */
    var inntektIK = 0.0

    /** Høyeste av akkumulert arbeidsinntekt hittil i år og forventet arbeidsinntekt.  */
    var inntektArbeid = 0.0

    /** Høyeste av akkumulert andre ytelser hittil i år og forventet andre ytelser.  */
    var andreYtelser = 0.0

}