package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

class TemporarYtelseskomponent : Ytelseskomponent() {
    init {
        ytelsekomponentType = YtelsekomponentTypeCti("TEMP")
    }
}