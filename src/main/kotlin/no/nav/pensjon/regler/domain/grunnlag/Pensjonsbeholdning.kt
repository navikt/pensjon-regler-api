package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.BeholdningtypeEnum

open class Pensjonsbeholdning : Beholdning() {
    override var beholdningsTypeEnum: BeholdningtypeEnum = BeholdningtypeEnum.PEN_B
}