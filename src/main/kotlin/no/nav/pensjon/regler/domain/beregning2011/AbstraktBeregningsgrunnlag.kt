package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import java.io.Serializable

abstract class AbstraktBeregningsgrunnlag protected constructor() : Serializable {
    var formelKode: FormelKodeCti? = null
    var arsbelop = 0

    /**
     * Antatt årlig inntekt før uføretidspunktet (brukes i fastsettelse av opptjening til alderspensjon etter kapittel 19).
     */
    var antattInntektFaktorKap19 = 0.0

    /**
     * Antatt årlig inntekt før uføretidspunktet (brukes i fastsettelse av opptjening til alderspensjon etter kapittel 20).
     */
    var antattInntektFaktorKap20 = 0.0

}