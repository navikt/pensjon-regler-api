package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.krav.Kravhode
import java.util.*
import java.time.LocalDate

class VilkarsprovForsorgingstilleggRequest : ServiceRequest() {
    var kravhode: Kravhode? = null
    var virkFomLd: LocalDate? = null
    var virkTomLd: LocalDate? = null
}