package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.ProRataBeregningTypeEnum
import java.io.Serializable

class EosEkstra : Serializable {
    var proRataBeregningTypeEnum: ProRataBeregningTypeEnum? = null
    var redusertAntFppAr: Int? = null
    var spt_eos: Double? = null
    var spt_pa_f92_eos: Int? = null
    var spt_pa_e91_eos: Int? = null
    var vilkar3_17Aok: Boolean? = null
}