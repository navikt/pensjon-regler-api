package no.nav.pensjon.regler.domain

import java.io.Serializable
import java.util.*
import java.time.LocalDate

class SatsResultat : Serializable {
    @Deprecated("Use fomLd instead")
    var fom: Date? = null
    var fomLd: LocalDate? = null
    @Deprecated("Use tomLd instead")
    var tom: Date? = null
    var tomLd: LocalDate? = null
    var verdi = 0.0
}