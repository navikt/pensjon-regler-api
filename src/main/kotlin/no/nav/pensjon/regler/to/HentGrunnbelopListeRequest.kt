package no.nav.pensjon.regler.to

import java.util.*
import java.time.LocalDate

class HentGrunnbelopListeRequest : ServiceRequest() {
    @Deprecated("Use fomLd instead")
    var fom: Date? = null
    var fomLd: LocalDate? = null
    @Deprecated("Use tomLd instead")
    var tom: Date? = null
    var tomLd: LocalDate? = null
}