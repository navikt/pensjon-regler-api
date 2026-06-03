package no.nav.pensjon.regler.domain

import java.io.Serializable
import java.util.*
import java.time.LocalDate

class SatsResultat : Serializable {
    var fomLd: LocalDate? = null
    var tomLd: LocalDate? = null
    var verdi = 0.0
}