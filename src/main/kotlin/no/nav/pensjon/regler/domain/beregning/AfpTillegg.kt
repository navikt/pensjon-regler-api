package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

class AfpTillegg : Ytelseskomponent() {
    init {
        ytelsekomponentType = YtelsekomponentTypeCti("AFP_T")
    }
}