package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.BeholdningtypeEnum

class AfpOpptjening : Beholdning() {
    override var beholdningsTypeEnum: BeholdningtypeEnum = BeholdningtypeEnum.AFP
}