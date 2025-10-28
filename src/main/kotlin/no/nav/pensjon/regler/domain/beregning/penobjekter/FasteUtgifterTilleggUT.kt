package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum

class FasteUtgifterTilleggUT : Ytelseskomponent() {
    var nettoAkk: Int? = null
    var nettoRestAr: Int? = null
    var avkortningsbelopPerAr: Int? = null

    override val ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.UT_FAST_UTGIFT_T
}