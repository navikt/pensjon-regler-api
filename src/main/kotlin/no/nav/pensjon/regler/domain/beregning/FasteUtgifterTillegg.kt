package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

/**
 * Tillegget for faste utgifter. Brukes ved institusjonsopphold.
 */
class FasteUtgifterTillegg : Ytelseskomponent() {
    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("FAST_UTGIFT_T")
}