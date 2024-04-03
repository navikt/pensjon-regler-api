package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.krav.Kravhode
import java.util.*

class VilkarsprovForsorgingstilleggRequest : ServiceRequest() {
    var kravhode: Kravhode? = null
    var virkFom: Date? = null
    var virkTom: Date? = null
}