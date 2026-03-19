package no.nav.pensjon.regler.to

import com.fasterxml.jackson.annotation.JsonAlias
import no.nav.pensjon.regler.domain.krav.Kravhode
import java.util.*
import java.time.LocalDate

class VilkarsprovAlderpensjonForsteUttakRequest : ServiceRequest() {
    var kravHode: Kravhode? = null
    @Deprecated("Use virkLd instead")
    @JsonAlias("fom")
    var virk: Date? = null
    @JsonAlias("fomLd")
    var virkLd: LocalDate? = null
    var uttaksgrad = 0
    var ft = 0.0
    var ft67Soker = 0.0
    var ft67SokerMinus1 = 0.0
    var ft67Virk = 0.0
    var ft67VirkMinus1 = 0.0
}