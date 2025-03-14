package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import java.io.Serializable

class BarnetilleggSerkullsbarnUT : AbstraktBarnetilleggUT, Serializable {
    /**
     * Brukers gjenlevendetillegg før justering.
     */
    var brukersGjenlevendetilleggForJustering = 0

    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.UT_TSB

    constructor(barnetilleggFellesbarnUT: BarnetilleggSerkullsbarnUT) : super(barnetilleggFellesbarnUT) {
        brukersGjenlevendetilleggForJustering = barnetilleggFellesbarnUT.brukersGjenlevendetilleggForJustering
    }

    constructor() {
        formelKodeEnum = FormelKodeEnum.BTx
    }
}