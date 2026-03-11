package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.krav.Kravhode
import java.util.*
import java.time.LocalDate

class VilkarsprovEktefelletillegg2011Request : ServiceRequest() {
    var kravhode: Kravhode? = null
    @Deprecated("Use fomLd instead")
    var fom: Date? = null
    var fomLd: LocalDate? = null
    @Deprecated("Use tomLd instead")
    var tom: Date? = null
    var tomLd: LocalDate? = null

}