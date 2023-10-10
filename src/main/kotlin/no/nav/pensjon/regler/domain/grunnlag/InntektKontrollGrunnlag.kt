package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.beregning2011.BeregnetUtbetalingsperiode
import java.io.Serializable
import java.util.*

class InntektKontrollGrunnlag : Serializable {
    /** Inneholder faktiske inntekter mottatt av bruker hittil i år.  */
    var faktiskeInntekterBrukerListe: List<FaktiskInntektsgrunnlag> = mutableListOf()

    /** Inneholder faktiske inntekter mottatt av EPS hittil i år.  */
    var faktiskeInntekterEPSListe: List<FaktiskInntektsgrunnlag> = mutableListOf()

    /** Inneholder forventede inntekter for bruker fra Inntektskomponenten.  */
    var forventetInntektBrukerListe: List<Inntektsgrunnlag> = mutableListOf()

    /** Inneholder forventede inntekter for EPS fra Inntektskomponenten.  */
    var forventetInntektEPSListe: List<Inntektsgrunnlag> = mutableListOf()

    /**
     * En liste med hva som er beregnet utbetalt av ytelser hittil i år for søker.
     * Listen inneholder et sett med kontinuerlige ikke-overlappende perioder
     */
    var beregnetUtbetalingsperiodeBrukerListe: List<BeregnetUtbetalingsperiode> = mutableListOf()

    /**
     * En liste med hva som er beregnet utbetalt av ytelser hittil i år for EPS.
     * Listen inneholder et sett med kontinuerlige ikke-overlappende perioder
     */
    var beregnetUtbetalingsperiodeEPSListe: List<BeregnetUtbetalingsperiode> = mutableListOf()

    /** Angir hvilken måned som kontrolleres.  */
    var kontrolldato: Date? = null

}