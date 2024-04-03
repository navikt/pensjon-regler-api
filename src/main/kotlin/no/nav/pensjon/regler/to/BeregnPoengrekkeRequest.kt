package no.nav.pensjon.regler.to

import java.util.*

class BeregnPoengrekkeRequest : ServiceRequest() {
    var fom: Date? = null
    var tom: Date? = null
}