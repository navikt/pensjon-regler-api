package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

/**
 * GjenlevendetilleggAP
 *
 * @author Lars Hartvigsen (Decisive), PK-20265
 * @author Magnus Bakken (Accenture), PK-20716
 */
class GjenlevendetilleggAP : Ytelseskomponent() {
    /**
     * Sum av GP, TP og PenT for AP2011 medregnet GJR.
     */
    var apKap19MedGJR = 0

    /**
     * Sum av GP, TP og PenT for AP2011 uten GJR.
     */
    var apKap19UtenGJR = 0

    init {
        ytelsekomponentType = YtelsekomponentTypeCti("AP_GJT")
    }
}