package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.PenPerson
import no.nav.pensjon.regler.domain.kode.OmsorgTypeCti
import java.io.Serializable

class Omsorgsgrunnlag : Serializable {
    var ar = 0
    var omsorgType: OmsorgTypeCti? = null
    var personOmsorgFor: PenPerson? = null
    var isBruk = false
}