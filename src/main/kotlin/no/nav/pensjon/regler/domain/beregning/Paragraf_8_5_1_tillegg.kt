package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

class Paragraf_8_5_1_tillegg : Ytelseskomponent() {
    init {
        ytelsekomponentType = YtelsekomponentTypeCti("8_5_1_T")
    }
}