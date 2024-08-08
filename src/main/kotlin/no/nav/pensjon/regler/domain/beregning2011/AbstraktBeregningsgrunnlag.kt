package no.nav.pensjon.regler.domain.beregning2011

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.beregning.BarnetilleggFellesbarn
import no.nav.pensjon.regler.domain.beregning.BarnetilleggSerkullsbarn
import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import java.io.Serializable

@JsonSubTypes(
    JsonSubTypes.Type(value = BeregningsgrunnlagKonvertert::class),
    JsonSubTypes.Type(value = BeregningsgrunnlagOrdiner::class),
    JsonSubTypes.Type(value = BeregningsgrunnlagYrkesskade::class),
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract class AbstraktBeregningsgrunnlag protected constructor() : Serializable {
    var formelKode: FormelKodeCti? = null
    var formelKodeEnum: FormelKodeEnum? = null
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