package no.nav.pensjon.regler.to

import java.util.*

class HentGrunnbelopListeRequest : ServiceRequest() {
    var fom: Date? = null
    var tom: Date? = null
}