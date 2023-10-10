package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.VeietSatsResultat
import java.io.Serializable
import java.util.*

class VeietSatsResponse : Serializable {
    var veietSatsResultater: List<VeietSatsResultat> = Vector()
}