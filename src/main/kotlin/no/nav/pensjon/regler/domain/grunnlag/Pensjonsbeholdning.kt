package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.BeholdningtypeEnum
import no.nav.pensjon.regler.domain.kode.BeholdningsTypeCti

open class Pensjonsbeholdning : Beholdning() {
    override var beholdningsType: BeholdningsTypeCti = BeholdningsTypeCti("PEN_B")
    override var beholdningsTypeEnum: BeholdningtypeEnum = BeholdningtypeEnum.PEN_B
}