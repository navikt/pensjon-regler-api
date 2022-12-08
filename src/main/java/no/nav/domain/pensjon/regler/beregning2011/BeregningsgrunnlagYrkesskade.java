package no.nav.domain.pensjon.regler.beregning2011;

/**
 * @author Steinar Hjellvik (Decisive) - PK-11391
 */
public class BeregningsgrunnlagYrkesskade extends AbstraktBeregningsgrunnlag {

	private int inntektVedSkadetidspunkt;

    /**
     * Angir det sluttpoengtall som yrkesskade beregningsgrunnlaget er omregnet fra.
     * Angår kun beregning av avdøde i sammenheng med nytt UT_GJT.
     */
	private double sluttpoengtall;

}
