package no.nav.pensjon.regler.domain.beregning

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.beregning2011.BasisGrunnpensjon
import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import no.nav.pensjon.regler.domain.enum.GPSatsTypeEnum
import no.nav.pensjon.regler.domain.enum.GarantiPensjonsnivaSatsEnum
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import no.nav.pensjon.regler.domain.trygdetid.AnvendtTrygdetid

/**
 * Grunnpensjon
 */
@JsonSubTypes(
    JsonSubTypes.Type(value = BasisGrunnpensjon::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
open class Grunnpensjon : Ytelseskomponent {
    /**
     * Prosentsatsen.
     */
    var pSats_gp = 0.0

    /**
     * Ordinår, forhøyet
     */
    var satsTypeEnum: GPSatsTypeEnum? = null

    var ektefelleInntektOver2G = false

    /**
     * Trygdetid anvendt i beregning av grunnpensjon.
     */
    var anvendtTrygdetid: AnvendtTrygdetid? = null

    override val ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.GP

    constructor() {
        formelKodeEnum = FormelKodeEnum.GPx
    }

    /**
     * Copy Constructor
     */
    constructor(gp: Grunnpensjon) : super(gp) {
        pSats_gp = gp.pSats_gp
        if (gp.satsTypeEnum != null) {
            satsTypeEnum = gp.satsTypeEnum
        }
        ektefelleInntektOver2G = gp.ektefelleInntektOver2G
        if (gp.anvendtTrygdetid != null) {
            anvendtTrygdetid = AnvendtTrygdetid(gp.anvendtTrygdetid!!)
        }
    }
}