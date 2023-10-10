package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

class MinstenivatilleggIndividuelt : Ytelseskomponent() {
    var mpn: MinstePensjonsniva? = null
    var garPN: Garantipensjonsniva? = null
    var samletPensjonForMNT = 0.0

    init {
        ytelsekomponentType = YtelsekomponentTypeCti("MIN_NIVA_TILL_INDV")
    }
}