package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.GuiPrompt;

/**
 * @author Aasmund Nordstoga (Accenture) PK-5549
 */
public class BeregningsgrunnlagKonvertert extends AbstraktBeregningsgrunnlag {

    private static final long serialVersionUID = -2091685660045789479L;

    private Skattekompensertbelop skattekompensertbelop;

    @GuiPrompt(prompt = "Inntekt ved skadetidspunkt")
    private int inntektVedSkadetidspunkt;

    public BeregningsgrunnlagKonvertert() {
        super();
    }

    public BeregningsgrunnlagKonvertert(BeregningsgrunnlagKonvertert beregningsgrunnlagKonvertert) {
        super(beregningsgrunnlagKonvertert);
        if(beregningsgrunnlagKonvertert.skattekompensertbelop != null){
            this.skattekompensertbelop = new Skattekompensertbelop(beregningsgrunnlagKonvertert.skattekompensertbelop);
        }
        this.inntektVedSkadetidspunkt = beregningsgrunnlagKonvertert.inntektVedSkadetidspunkt;
    }

    public Skattekompensertbelop getSkattekompensertbelop() {
        return skattekompensertbelop;
    }

    public void setSkattekompensertbelop(Skattekompensertbelop skattekompensertbelop) {
        this.skattekompensertbelop = skattekompensertbelop;
    }

    public int getInntektVedSkadetidspunkt() {
        return inntektVedSkadetidspunkt;
    }

    public void setInntektVedSkadetidspunkt(int inntektVedSkadetidspunkt) {
        this.inntektVedSkadetidspunkt = inntektVedSkadetidspunkt;
    }
}
