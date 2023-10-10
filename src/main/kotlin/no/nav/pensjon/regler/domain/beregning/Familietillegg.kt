package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

class Familietillegg : Ytelseskomponent() {
    init {
        ytelsekomponentType = YtelsekomponentTypeCti("FAM_T")
    }
}