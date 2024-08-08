package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import java.io.Serializable

class BarnetilleggFellesbarnUT : AbstraktBarnetilleggUT, Serializable {
    /**
     * beløp som er fratrukket annen forelders inntekt (inntil 1G)
     */
    var belopFratrukketAnnenForeldersInntekt = 0

    /**
     * Brukers inntekt
     */
    var brukersInntektTilAvkortning = 0

    /**
     * Annen forelders inntekt brukt i behovsprøving
     */
    var inntektAnnenForelder = 0

    /**
     * Annen forelders uføretrygd før justering.
     */
    var annenForelderUforetrygdForJustering = 0

    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("UT_TFB")
    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.UT_TFB

    constructor() {
        formelKode = FormelKodeCti("BTx")
        formelKodeEnum = FormelKodeEnum.BTx
    }

    constructor(barnetilleggFellesbarnUT: BarnetilleggFellesbarnUT) : super(barnetilleggFellesbarnUT) {
        belopFratrukketAnnenForeldersInntekt = barnetilleggFellesbarnUT.belopFratrukketAnnenForeldersInntekt
        brukersInntektTilAvkortning = barnetilleggFellesbarnUT.brukersInntektTilAvkortning
        inntektAnnenForelder = barnetilleggFellesbarnUT.inntektAnnenForelder
        annenForelderUforetrygdForJustering = barnetilleggFellesbarnUT.annenForelderUforetrygdForJustering
    }
}