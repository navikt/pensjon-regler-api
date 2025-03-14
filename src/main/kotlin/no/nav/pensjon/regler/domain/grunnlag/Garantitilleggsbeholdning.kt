package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.beregning2011.GarantitilleggInformasjon
import no.nav.pensjon.regler.domain.enum.BeholdningtypeEnum

class Garantitilleggsbeholdning : Beholdning() {
    var garantitilleggInformasjon: GarantitilleggInformasjon? = null
    override var beholdningsTypeEnum: BeholdningtypeEnum = BeholdningtypeEnum.GAR_T_B
}