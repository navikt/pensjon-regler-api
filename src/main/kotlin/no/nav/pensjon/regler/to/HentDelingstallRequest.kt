package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.sats.delingstall.Alder

class HentDelingstallRequest : ServiceRequest() {
    var arskull: Long = 0
    var alder: List<Alder> = emptyList()
}