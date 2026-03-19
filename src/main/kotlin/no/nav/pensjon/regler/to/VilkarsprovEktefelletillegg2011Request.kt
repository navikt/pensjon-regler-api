package no.nav.pensjon.regler.to

import com.fasterxml.jackson.annotation.JsonAlias
import no.nav.pensjon.regler.domain.krav.Kravhode
import java.util.*
import java.time.LocalDate

class VilkarsprovEktefelletillegg2011Request : ServiceRequest() {
    var kravhode: Kravhode? = null
    @Deprecated("Use virkLd instead")
    @JsonAlias("fom")
    var virk: Date? = null
    @JsonAlias("fomLd")
    var virkLd: LocalDate? = null
    @Deprecated("Use tomLd instead")
    @JsonAlias("tom")
    var tom: Date? = null
    var tomLd: LocalDate? = null

}