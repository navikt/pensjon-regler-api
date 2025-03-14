package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum

/**
 * Tillegget for faste utgifter. Brukes ved institusjonsopphold.
 */
class FasteUtgifterTillegg : Ytelseskomponent() {
    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.FAST_UTGIFT_T
}