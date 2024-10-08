package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.enum.SatsTypeEnum
import no.nav.pensjon.regler.domain.kode.SatsTypeCti
import java.util.*

class HentGyldigSatsRequest : ServiceRequest() {
    var fomDato: Date? = null
    var tomDato: Date? = null
    var satsType: SatsTypeCti? = null
    var satsTypeEnum: SatsTypeEnum? = null
    var beregnetSomGift = false
    var forsorgerEPSOver60 = false
    var ungUfor = false
}