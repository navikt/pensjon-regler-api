package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

class FasteUtgifterTilleggUT : Ytelseskomponent() {
    var nettoAkk: Int? = null
    var nettoRestAr: Int? = null
    var avkortningsbelopPerAr: Int? = null

    init {
        ytelsekomponentType = YtelsekomponentTypeCti("UT_FAST_UTGIFT_T")
    }
}