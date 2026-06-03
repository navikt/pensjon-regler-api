package no.nav.pensjon.regler.to

import java.util.*
import java.time.LocalDate

class HentGrunnbelopListeRequest : ServiceRequest() {
    var fomLd: LocalDate? = null
    var tomLd: LocalDate? = null
}