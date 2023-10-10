package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*

class GarantiTrygdetid : Serializable {
    var trygdetid_garanti = 0
    var fomDato: Date? = null
    var tomDato: Date? = null

}