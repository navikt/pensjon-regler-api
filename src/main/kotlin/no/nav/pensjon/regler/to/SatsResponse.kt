package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.SatsResultat

import java.util.*

class SatsResponse : ServiceResponse() {
    var satsResultater: List<SatsResultat> = Vector()

}