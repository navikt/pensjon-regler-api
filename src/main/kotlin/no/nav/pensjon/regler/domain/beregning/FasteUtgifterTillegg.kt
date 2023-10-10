package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

/**
 * Tillegget for faste utgifter. Brukes ved institusjonsopphold.
 */
class FasteUtgifterTillegg : Ytelseskomponent() {
    init {
        ytelsekomponentType = YtelsekomponentTypeCti("FAST_UTGIFT_T")
    }
}