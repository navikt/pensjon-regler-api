package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import java.io.Serializable

/**
 * @author Aasmund Nordstoga (Accenture) PK-5549
 */
class Overgangsbelop : Serializable {
    var formelKode: FormelKodeCti? = null
    var gpBrutto = 0
    var gpSats = 0.0
    var overgangsbelop = 0.0
    var stBrutto = 0
    var tpBrutto = 0

}