package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

class Sertillegg : Ytelseskomponent() {
    /**
     * Prosentsatsen
     */
    var pSats_st = 0.0
    var pREG_orginalBrutto = 0
    var pREG_orginalBruttoPerAr = 0.0


    init {
        ytelsekomponentType = YtelsekomponentTypeCti("ST")
    }

}