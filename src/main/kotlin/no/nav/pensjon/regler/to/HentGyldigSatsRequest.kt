package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.enum.SatsTypeEnum
import java.util.*
import java.time.LocalDate

class HentGyldigSatsRequest : ServiceRequest() {
    var fomDatoLd: LocalDate? = null
    var tomDatoLd: LocalDate? = null
    var satsTypeEnum: SatsTypeEnum? = null
    var beregnetSomGift = false
    var forsorgerEPSOver60 = false
    var ungUfor = false
}