package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.krav.Kravhode
import java.util.*
import java.time.LocalDate

class VilkarsprovEktefelletillegg2011Request : ServiceRequest() {
    var kravhode: Kravhode? = null
    var fomLd: LocalDate? = null
    var tomLd: LocalDate? = null

}