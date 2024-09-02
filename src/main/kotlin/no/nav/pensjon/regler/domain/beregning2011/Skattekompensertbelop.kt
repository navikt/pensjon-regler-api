package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import java.io.Serializable

class Skattekompensertbelop : Serializable {
    var faktor = 0.0
    var formelKode: FormelKodeCti? = null
    var formelKodeEnum: FormelKodeEnum? = null
    var arsbelop = 0.0
    var justertbelop: Justertbelop? = null
    var tillegg = 0.0

}