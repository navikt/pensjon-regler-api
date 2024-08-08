package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

class FasteUtgifterTilleggUT : Ytelseskomponent() {
    var nettoAkk: Int? = null
    var nettoRestAr: Int? = null
    var avkortningsbelopPerAr: Int? = null

    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("UT_FAST_UTGIFT_T")
    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.UT_FAST_UTGIFT_T
}