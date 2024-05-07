package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

class Skjermingstillegg : Ytelseskomponent() {
    var ft67Soker: Double? = null
    var skjermingsgrad: Double? = null
    var ufg: Int? = null
    var basGp_bruttoPerAr: Double? = null
    var basTp_bruttoPerAr: Double? = null
    var basPenT_bruttoPerAr: Double? = null

    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("SKJERMT")

}