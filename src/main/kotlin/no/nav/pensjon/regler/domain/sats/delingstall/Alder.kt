package no.nav.pensjon.regler.domain.sats.delingstall

import java.io.Serializable

data class Alder(
    val aar: Long,
    val maaneder: Long
) : Serializable