package no.nav.pensjon.regler.to

import java.util.*
import java.time.LocalDate

class BeregnPoengrekkeRequest : ServiceRequest() {
    var fomLd: LocalDate? = null
    var tomLd: LocalDate? = null
}