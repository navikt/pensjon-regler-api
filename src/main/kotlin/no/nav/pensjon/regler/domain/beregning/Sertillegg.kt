package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum

class Sertillegg : Ytelseskomponent() {
    /**
     * Prosentsatsen
     */
    var pSats_st = 0.0

    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.ST
}