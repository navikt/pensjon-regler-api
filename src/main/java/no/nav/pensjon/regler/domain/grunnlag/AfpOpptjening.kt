package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.kode.BeholdningsTypeCti

class AfpOpptjening : Beholdning() {
    init {
        beholdningsType = BeholdningsTypeCti("AFP")
    }
}