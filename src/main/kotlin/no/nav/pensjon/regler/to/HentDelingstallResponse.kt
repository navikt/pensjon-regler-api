package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.sats.delingstall.Delingstall

class HentDelingstallResponse : ServiceResponse() {
    var arskull: Long = 0
    var delingstall: List<Delingstall> = emptyList()
}