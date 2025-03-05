package no.nav.pensjon.regler.domain.sats.delingstall

import java.io.Serializable

data class Delingstall (
    val alder: Alder,
    val delingstall : Double
): Serializable