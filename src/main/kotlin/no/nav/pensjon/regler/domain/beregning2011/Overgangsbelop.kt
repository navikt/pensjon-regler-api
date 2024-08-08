package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import java.io.Serializable

class Overgangsbelop : Serializable {
    var formelKode: FormelKodeCti? = null
    var formelKodeEnum: FormelKodeEnum? = null
    var gpBrutto = 0
    var gpSats = 0.0
    var overgangsbelop = 0.0
    var stBrutto = 0
    var tpBrutto = 0

}