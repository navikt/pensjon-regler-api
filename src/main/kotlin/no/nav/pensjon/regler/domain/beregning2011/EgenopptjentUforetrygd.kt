package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import no.nav.pensjon.regler.domain.trygdetid.AnvendtTrygdetid
import java.io.Serializable

class EgenopptjentUforetrygd : Serializable {
    var faktor = 0.66
    var formelKodeEnum: FormelKodeEnum? = null
    var arsbelop = 0
    var beregningsgrunnlagOrdiner: AbstraktBeregningsgrunnlag? = null
        set(aBeregningsgrunnlag) {
            if (aBeregningsgrunnlag is BeregningsgrunnlagOrdiner
                || aBeregningsgrunnlag is BeregningsgrunnlagKonvertert
            ) {
                field = aBeregningsgrunnlag
            }
        }
    var beregningsgrunnlagYrkesskade: AbstraktBeregningsgrunnlag? = null
        set(aBeregningsgrunnlag) {
            if (aBeregningsgrunnlag is BeregningsgrunnlagYrkesskade
                || aBeregningsgrunnlag is BeregningsgrunnlagKonvertert
            ) {
                field = aBeregningsgrunnlag
            }
        }
    var beregningsgrunnlagYrkesskadeBest = false

    /**
     * Prosentsats brukt for Påslag.
     */
    var konverteringsPaslagForRedGP = 0

    /**
     * Påslag pga økt redusert grunnpensjon sats til egenopptjent uføretrygd som angår konvertert Uføretidpunkt.
     */
    var konverteringsPaslagForRedGPSats = 0

    /**
     * Trygdetid som er brukt ved beregning av egenopptjent uføretrygd.
     */
    var anvendtTrygdetid: AnvendtTrygdetid? = null
}