package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.GuiPrompt;

/**
 * @author Steinar Hjellvik (Decisive) - PK-11391
 */
public class BeregningsgrunnlagYrkesskade extends AbstraktBeregningsgrunnlag {
	
	private static final long serialVersionUID = 3545891503020530843L;

	@GuiPrompt(prompt = "Inntekt ved skadetidspunkt")
	private int inntektVedSkadetidspunkt;

    /**
     * Angir det sluttpoengtall som yrkesskade beregningsgrunnlaget er omregnet fra.
     * Angår kun beregning av avdøde i sammenheng med nytt UT_GJT.
     */
	@GuiPrompt(prompt = "Sluttpoengtall som yrkesskade beregningsgrunnlag er omregnet fra")
    private double sluttpoengtall;

	public BeregningsgrunnlagYrkesskade() {
		super();
	}

	public BeregningsgrunnlagYrkesskade(BeregningsgrunnlagYrkesskade beregningsgrunnlagYrkesskade) {
		super(beregningsgrunnlagYrkesskade);
		this.inntektVedSkadetidspunkt = beregningsgrunnlagYrkesskade.inntektVedSkadetidspunkt;
        this.sluttpoengtall = beregningsgrunnlagYrkesskade.sluttpoengtall;
	}

	public int getInntektVedSkadetidspunkt() {
		return inntektVedSkadetidspunkt;
	}

	public void setInntektVedSkadetidspunkt(int inntektVedSkadetidspunkt) {
		this.inntektVedSkadetidspunkt = inntektVedSkadetidspunkt;
	}

    public double getSluttpoengtall() {
        return sluttpoengtall;
    }

    public void setSluttpoengtall(double sluttpoengtall) {
        this.sluttpoengtall = sluttpoengtall;
    }
}
