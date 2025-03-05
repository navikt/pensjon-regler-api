package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.sats.delingstall.Delingstall

data class HentDelingstallResponse (
    val arskull: Long,
    val delingstall: List<Delingstall>
)