package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import no.nav.pensjon.regler.domain.enum.UtfallEnum
import no.nav.pensjon.regler.domain.trygdetid.AnvendtTrygdetid
import java.io.Serializable

class Minsteytelse : Serializable {
    var formelKodeEnum: FormelKodeEnum? = null
    var merknadListe: List<Merknad> = mutableListOf()
    var satsMinsteytelse: SatsMinsteytelse? = null
    var arsbelop = 0
    var eksportforbud = false

    /**
     * Trygdetid som er brukt ved beregning av minsteytelsen.
     */
    var anvendtTrygdetid: AnvendtTrygdetid? = null
    var anvendtFlyktningEnum: UtfallEnum? = null

}