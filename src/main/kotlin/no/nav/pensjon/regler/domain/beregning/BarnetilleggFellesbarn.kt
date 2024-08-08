package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.beregning2011.AbstraktBarnetillegg
import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import java.io.Serializable

class BarnetilleggFellesbarn : AbstraktBarnetillegg, Serializable {

    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("TFB")
    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.TFB

    constructor() {
        formelKode = FormelKodeCti("BTx")
        formelKodeEnum = FormelKodeEnum.BTx
    }

    constructor (barnetilleggFellesbarn: BarnetilleggFellesbarn) : super(barnetilleggFellesbarn)
}