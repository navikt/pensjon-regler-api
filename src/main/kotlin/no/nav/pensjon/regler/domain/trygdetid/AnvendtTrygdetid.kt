package no.nav.pensjon.regler.domain.trygdetid

import java.io.Serializable

/**
 * Anvendt trygdetid i beregning av grunnpensjon med mer.
 */
class AnvendtTrygdetid : Serializable {
    /**
     * Anvendt trygdetid i antall år.
     */
    var tt_anv = 0

    /**
     * Anvendt pro rata brøk hvis grunnpensjon er pro rata beregnet.
     * Teller er lik antall måneder faktisk trygdetid i Norge.
     * Nevner er lik antall måneder faktisk trygdetid i Norge og i avtaleland.
     */
    var pro_rata: Brok? = null

    constructor()
    constructor(anvendtTrygdetid: AnvendtTrygdetid) :super() {
        tt_anv = anvendtTrygdetid.tt_anv
        if (anvendtTrygdetid.pro_rata != null) {
            pro_rata = Brok(anvendtTrygdetid.pro_rata!!)
        }
    }
}