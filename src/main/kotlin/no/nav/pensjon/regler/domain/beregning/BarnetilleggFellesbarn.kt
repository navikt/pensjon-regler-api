package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.beregning2011.AbstraktBarnetillegg
import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import java.io.Serializable

class BarnetilleggFellesbarn : AbstraktBarnetillegg, Serializable {

    override val ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.TFB

    constructor() {
        formelKodeEnum = FormelKodeEnum.BTx
    }

    constructor (barnetilleggFellesbarn: BarnetilleggFellesbarn) : super(barnetilleggFellesbarn)
}