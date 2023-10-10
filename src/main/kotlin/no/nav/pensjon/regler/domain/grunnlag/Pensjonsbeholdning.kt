package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.kode.BeholdningsTypeCti

open class Pensjonsbeholdning : Beholdning() {
    init {
        beholdningsType = BeholdningsTypeCti("PEN_B")
    }
}