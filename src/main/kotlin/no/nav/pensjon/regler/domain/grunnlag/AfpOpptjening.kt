package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.BeholdningtypeEnum
import no.nav.pensjon.regler.domain.kode.BeholdningsTypeCti

class AfpOpptjening : Beholdning() {
    override var beholdningsType: BeholdningsTypeCti = BeholdningsTypeCti("AFP")
    override var beholdningsTypeEnum: BeholdningtypeEnum = BeholdningtypeEnum.AFP
}