package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.SatsResultat
import java.io.Serializable
import java.util.*

class SatsResponse : Serializable {
    var satsResultater: List<SatsResultat> = Vector()

}