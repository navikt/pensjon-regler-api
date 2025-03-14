package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.GrunnlagkildeEnum
import no.nav.pensjon.regler.domain.enum.OpptjeningtypeEnum
import java.io.Serializable

class Opptjeningsgrunnlag : Serializable {
    /**
     * år for opptjeningen.
     */
    var ar = 0

    /**
     * Pensjonsgivende inntekt.
     */
    var pi = 0

    /**
     * Anvendt pensjonsgivende inntekt.Redusert pi etter 1/3-regelen.
     * Brukes ved beregning av poengtallene.<br></br>
     * `0 =< pia <= 8.33G (som int)`
     */
    var pia = 0

    /**
     * Beregnet pensjonspoeng.
     */
    var pp = 0.0

    /**
     * Angir type opptjening. Se K_OPPTJN_T.
     * Pr september 2007 så tabellen slik ut:
     * OSFE Omsorg for syke/funksjonshemmede/eldre
     * OBO7H Omsorg for barn over 7 år med hjelpestønad sats 3 eller 4
     * OBU7 Omsorg for barn under 7 år
     * PPI Pensjonsgivende inntekt
     */
    var opptjeningTypeEnum: OpptjeningtypeEnum? = null

    /**
     * Maks Uføregrad for dette året
     */
    var maksUforegrad = 0

    /**
     * Angir om opptjeningsgrunnlaget brukes somm grunnlag på kravet.
     */
    var bruk: Boolean = true

    /**
     * Kilden til opptjeningsgrunnlaget.
     */
    var grunnlagKildeEnum: GrunnlagkildeEnum? = null

    /**
     * Inneholder alle inntektstyper for dette året
     */
    var opptjeningTypeListe: MutableList<OpptjeningTypeMapping> = mutableListOf()
}