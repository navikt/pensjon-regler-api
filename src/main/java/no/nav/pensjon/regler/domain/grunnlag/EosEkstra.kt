package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.kode.ProRataBeregningTypeCti
import java.io.Serializable

class EosEkstra : Serializable {
    var proRataBeregningType: ProRataBeregningTypeCti? = null
    var redusertAntFppAr: Int? = null
    var spt_eos: Double? = null
    var spt_pa_f92_eos: Int? = null
    var spt_pa_e91_eos: Int? = null
    var vilkar3_17Aok: Boolean? = null
}