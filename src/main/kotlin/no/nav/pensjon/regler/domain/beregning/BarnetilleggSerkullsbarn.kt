package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.beregning2011.AbstraktBarnetillegg
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import java.io.Serializable

class BarnetilleggSerkullsbarn : AbstraktBarnetillegg, Serializable {
    init {
        ytelsekomponentType = YtelsekomponentTypeCti("TSB")
    }

    constructor() {
        formelKode = FormelKodeCti("BTx")
    }

    constructor(barnetilleggSerkullsbarn: BarnetilleggSerkullsbarn) : super(barnetilleggSerkullsbarn)
}