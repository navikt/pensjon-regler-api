package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.beregning2011.BeregnetUtbetalingsperiode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InntektKontrollGrunnlag implements Serializable {



    /** Inneholder faktiske inntekter mottatt av bruker hittil i år. */
    private List<FaktiskInntektsgrunnlag> faktiskeInntekterBrukerListe = new ArrayList<FaktiskInntektsgrunnlag>();

    /** Inneholder faktiske inntekter mottatt av EPS hittil i år. */
    private List<FaktiskInntektsgrunnlag> faktiskeInntekterEPSListe = new ArrayList<FaktiskInntektsgrunnlag>();

    /** Inneholder forventede inntekter for bruker fra Inntektskomponenten. */
    private List<Inntektsgrunnlag> forventetInntektBrukerListe = new ArrayList<Inntektsgrunnlag>();

    /** Inneholder forventede inntekter for EPS fra Inntektskomponenten. */
    private List<Inntektsgrunnlag> forventetInntektEPSListe = new ArrayList<Inntektsgrunnlag>();

    /**
     * En liste med hva som er beregnet utbetalt av ytelser hittil i år for søker.
     * Listen inneholder et sett med kontinuerlige ikke-overlappende perioder
     */
    private List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeBrukerListe = new ArrayList<BeregnetUtbetalingsperiode>();

    /**
     * En liste med hva som er beregnet utbetalt av ytelser hittil i år for EPS.
     * Listen inneholder et sett med kontinuerlige ikke-overlappende perioder
     */
    private List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeEPSListe = new ArrayList<BeregnetUtbetalingsperiode>();

    /** Angir hvilken måned som kontrolleres. */
    private Date kontrolldato;

}
