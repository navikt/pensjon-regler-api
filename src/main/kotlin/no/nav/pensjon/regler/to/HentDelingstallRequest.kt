package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.sats.delingstall.Alder

data class HentDelingstallRequest (
    var arskull: Long,
    var alder: List<Alder>
)