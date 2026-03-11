package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.krav.Kravhode
import java.util.*
import java.time.LocalDate

class VilkarsprovAlderpensjonForsteUttakRequest : ServiceRequest() {
    var kravHode: Kravhode? = null
    @Deprecated("Use fomLd instead")
    var fom: Date? = null
    var fomLd: LocalDate? = null
    var uttaksgrad = 0
    var ft = 0.0
    var ft67Soker = 0.0
    var ft67SokerMinus1 = 0.0
    var ft67Virk = 0.0
    var ft67VirkMinus1 = 0.0
}