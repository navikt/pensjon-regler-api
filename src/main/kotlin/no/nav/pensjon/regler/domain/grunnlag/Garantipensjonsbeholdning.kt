package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.beregning2011.JustertGarantipensjonsniva
import no.nav.pensjon.regler.domain.kode.BeholdningsTypeCti
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.GarantipenNivaCti

class Garantipensjonsbeholdning() : Beholdning() {
    var justertGarantipensjonsniva: JustertGarantipensjonsniva? = null
    var pensjonsbeholdning = 0.0
    var delingstall67 = 0.0

    /**
     * Satstype brukt i garantipensjonsnivå.
     */
    var satsType: GarantipenNivaCti? = null

    /**
     * Garantipensjonsnivå sats
     */
    var sats = 0.0

    /**
     * Garantipensjonsnivå justert for trygdetid
     */
    var garPN_tt_anv = 0.0

    /**
     * Garantipensjonsnivå fremskrevet.
     */
    var garPN_justert = 0.0

    override var beholdningsType: BeholdningsTypeCti = BeholdningsTypeCti("GAR_PEN_B")
}