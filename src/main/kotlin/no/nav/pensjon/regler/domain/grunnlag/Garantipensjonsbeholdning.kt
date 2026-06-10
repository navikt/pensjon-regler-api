package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.beregning2011.JustertGarantipensjonsniva
import no.nav.pensjon.regler.domain.enum.BeholdningtypeEnum
import no.nav.pensjon.regler.domain.enum.GarantiPensjonsnivaSatsEnum

class Garantipensjonsbeholdning() : Beholdning() {
    var justertGarantipensjonsniva: JustertGarantipensjonsniva? = null
    var pensjonsbeholdning = 0.0
    var delingstallVedNormertPensjonsalder = 0.0

    /**
     * Satstype brukt i garantipensjonsnivå.
     */
    var satsTypeEnum: GarantiPensjonsnivaSatsEnum? = null

    /**
     * Garantipensjonsnivå sats
     */
    var sats = 0.0

    /**
     * Har ektefelle inntekt over 2G ved virk.
     * Bidrar til å avgjøre [satsTypeEnum]
     */
    var ektefelleInntektOver2G: Boolean = false

    /**
     * Garantipensjonsnivå justert for trygdetid
     */
    var garPN_tt_anv = 0.0

    /**
     * Garantipensjonsnivå fremskrevet.
     */
    var garPN_justert = 0.0

    override var beholdningsTypeEnum: BeholdningtypeEnum = BeholdningtypeEnum.GAR_PEN_B
}