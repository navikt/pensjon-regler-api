package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.beregning2011.AbstraktBarnetillegg
import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import java.io.Serializable

class BarnetilleggSerkullsbarn : AbstraktBarnetillegg, Serializable {
    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.TSB

    constructor() {
        formelKodeEnum = FormelKodeEnum.BTx
    }

    constructor(barnetilleggSerkullsbarn: BarnetilleggSerkullsbarn) : super(barnetilleggSerkullsbarn)
}