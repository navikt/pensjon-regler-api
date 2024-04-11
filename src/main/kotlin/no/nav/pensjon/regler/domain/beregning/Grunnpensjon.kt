package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.GPSatsTypeCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import no.nav.pensjon.regler.domain.trygdetid.AnvendtTrygdetid

/**
 * Grunnpensjon
 */
open class Grunnpensjon : Ytelseskomponent {
    /**
     * Prosentsatsen.
     */
    var pSats_gp = 0.0

    /**
     * Ordinår, forhøyet
     */
    var satsType: GPSatsTypeCti? = null
    var ektefelleInntektOver2G = false

    /**
     * Trygdetid anvendt i beregning av grunnpensjon.
     */
    var anvendtTrygdetid: AnvendtTrygdetid? = null

    init {
        ytelsekomponentType = YtelsekomponentTypeCti("GP")
    }

    constructor() {
        formelKode = FormelKodeCti("GPx")
    }

    /**
     * Copy Constructor
     */
    constructor(gp: Grunnpensjon) : super(gp) {
        pSats_gp = gp.pSats_gp
        if (gp.satsType != null) {
            satsType = GPSatsTypeCti(gp.satsType!!)
        }
        ektefelleInntektOver2G = gp.ektefelleInntektOver2G
        if (gp.anvendtTrygdetid != null) {
            anvendtTrygdetid = AnvendtTrygdetid(gp.anvendtTrygdetid!!)
        }
    }
}