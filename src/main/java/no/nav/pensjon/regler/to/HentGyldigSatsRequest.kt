package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.kode.SatsTypeCti
import java.util.*

class HentGyldigSatsRequest {
    var fomDato: Date? = null
    var tomDato: Date? = null
    var satsType: SatsTypeCti? = null
    var isBeregnetSomGift = false
    var isForsorgerEPSOver60 = false
    var isUngUfor = false
}