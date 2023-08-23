package no.nav.pensjon.regler.domain

import java.io.Serializable
import java.util.*

class SatsResultat : Serializable {
    var fom: Date? = null
    var tom: Date? = null
    var verdi = 0.0
}