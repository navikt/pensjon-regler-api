package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.beregning2011.AbstraktBarnetillegg
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import java.io.Serializable

class BarnetilleggFellesbarn : AbstraktBarnetillegg, Serializable {

    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("TFB")

    constructor() {
        formelKode = FormelKodeCti("BTx")
    }

    constructor (barnetilleggFellesbarn: BarnetilleggFellesbarn) : super(barnetilleggFellesbarn)
}