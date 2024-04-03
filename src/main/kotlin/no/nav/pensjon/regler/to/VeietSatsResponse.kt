package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.VeietSatsResultat

import java.util.*

class VeietSatsResponse : ServiceResponse() {
    var veietSatsResultater: List<VeietSatsResultat> = Vector()
}