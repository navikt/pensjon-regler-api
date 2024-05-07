package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import java.io.Serializable

class BarnetilleggSerkullsbarnUT : AbstraktBarnetilleggUT, Serializable {
    /**
     * Brukers gjenlevendetillegg før justering.
     */
    var brukersGjenlevendetilleggForJustering = 0

    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("UT_TSB")

    constructor(barnetilleggFellesbarnUT: BarnetilleggSerkullsbarnUT) : super(barnetilleggFellesbarnUT) {
        brukersGjenlevendetilleggForJustering = barnetilleggFellesbarnUT.brukersGjenlevendetilleggForJustering
    }

    constructor() {
        formelKode = FormelKodeCti("BTx")
    }
}