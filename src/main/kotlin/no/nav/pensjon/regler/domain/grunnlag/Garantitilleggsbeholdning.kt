package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.beregning2011.GarantitilleggInformasjon
import no.nav.pensjon.regler.domain.kode.BeholdningsTypeCti

class Garantitilleggsbeholdning : Beholdning() {
    var garantitilleggInformasjon: GarantitilleggInformasjon? = null
    override var beholdningsType: BeholdningsTypeCti = BeholdningsTypeCti("GAR_T_B")
}