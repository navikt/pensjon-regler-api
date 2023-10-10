package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import no.nav.pensjon.regler.domain.trygdetid.Brok
import no.nav.pensjon.regler.domain.util.formula.Formel
import no.nav.pensjon.regler.domain.util.formula.IFormelProvider

class GjenlevendetilleggAPKap19 : Ytelseskomponent(), IFormelProvider {
    /**
     * Sum av GP, TP og PenT for AP2011 medregnet GJR.
     */
    var apKap19MedGJR = 0

    /**
     * Sum av GP, TP og PenT for AP2011 uten GJR.
     */
    var apKap19UtenGJR = 0

    /**
     * Referansebel�p beregnet av differanse mellom APKap19 med og uten GJR.
     */
    var referansebelop = 0
    var eksportfaktor: Brok? = null

    /**
     * Map av formler brukt i beregning av Tilleggspensjon.
     */
    override var formelMap: HashMap<String, Formel> = HashMap()

    init {
        ytelsekomponentType = YtelsekomponentTypeCti("AP_GJT_KAP19")
    }

    override val formelPrefix: String
        get() = "GJT_Kap19"
}