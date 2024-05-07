package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.kode.BeholdningsTypeCti

class AfpOpptjening : Beholdning() {
    override var beholdningsType: BeholdningsTypeCti = BeholdningsTypeCti("AFP")
}