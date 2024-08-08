package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.beregning2011.AbstraktBarnetillegg
import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import java.io.Serializable

class BarnetilleggSerkullsbarn : AbstraktBarnetillegg, Serializable {
    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("TSB")
    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.TSB

    constructor() {
        formelKode = FormelKodeCti("BTx")
        formelKodeEnum = FormelKodeEnum.BTx
    }

    constructor(barnetilleggSerkullsbarn: BarnetilleggSerkullsbarn) : super(barnetilleggSerkullsbarn)
}