package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.GuiPrompt;
import no.nav.pensjon.regler.domain.kode.FormelKodeCti;

import java.io.Serializable;

/**
 * @author Steinar Hjellvik (Decisive) - PK-6458
 * @author Magnus Bakken (Accenture) - PK-20759
 */
public abstract class AbstraktBeregningsgrunnlag implements Serializable {

    private static final long serialVersionUID = -8142049555303833817L;

    @GuiPrompt(prompt = "Formel")
    private FormelKodeCti formelKode;

    @GuiPrompt(prompt = "Årsbeløp")
    private int arsbelop;

    /**
     *  Antatt årlig inntekt før uføretidspunktet (brukes i fastsettelse av opptjening til alderspensjon etter kapittel 19).
     */
    @GuiPrompt(prompt = "Antatt årlig inntekt før uføretidspunkt, kapittel 19")
    private double antattInntektFaktorKap19;

    /**
     *  Antatt årlig inntekt før uføretidspunktet (brukes i fastsettelse av opptjening til alderspensjon etter kapittel 20).
     */
    @GuiPrompt(prompt = "Antatt årlig inntekt før uføretidspunkt, kapittel 20")
    private double antattInntektFaktorKap20;

    protected AbstraktBeregningsgrunnlag() {
        super();
    }

    protected AbstraktBeregningsgrunnlag(AbstraktBeregningsgrunnlag abstraktBeregningsgrunnlag) {
        if (abstraktBeregningsgrunnlag.formelKode != null) {
            formelKode = new FormelKodeCti(abstraktBeregningsgrunnlag.formelKode);
        }
        arsbelop = abstraktBeregningsgrunnlag.arsbelop;
        antattInntektFaktorKap19 = abstraktBeregningsgrunnlag.antattInntektFaktorKap19;
        antattInntektFaktorKap20 = abstraktBeregningsgrunnlag.antattInntektFaktorKap20;
    }

    public FormelKodeCti getFormelKode() {
        return formelKode;
    }

    public void setFormelKode(FormelKodeCti formelKode) {
        this.formelKode = formelKode;
    }

    public int getArsbelop() {
        return arsbelop;
    }

    public void setArsbelop(int arsbelop) {
        this.arsbelop = arsbelop;
    }

    public double getAntattInntektFaktorKap19() {
        return antattInntektFaktorKap19;
    }

    public void setAntattInntektFaktorKap19(double antattInntektFaktorKap19) {
        this.antattInntektFaktorKap19 = antattInntektFaktorKap19;
    }

    public double getAntattInntektFaktorKap20() {
        return antattInntektFaktorKap20;
    }

    public void setAntattInntektFaktorKap20(double antattInntektFaktorKap20) {
        this.antattInntektFaktorKap20 = antattInntektFaktorKap20;
    }
}
