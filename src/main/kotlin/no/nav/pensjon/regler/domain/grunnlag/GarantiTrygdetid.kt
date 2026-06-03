package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*
import java.time.LocalDate

class GarantiTrygdetid : Serializable {
    var trygdetid_garanti = 0
    var fomDatoLd: LocalDate? = null
    var tomDatoLd: LocalDate? = null

}