package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.GuiPrompt;

import java.io.Serializable;

public class InntektsberegningsResultat implements Serializable {

    private static final long serialVersionUID = -1933024004904240799L;

    /** Ny forventet inntekt for TSB. */
    @GuiPrompt(prompt = "Ny forventet inntekt for barnetillegg særkullsbarn")
    private InntektBT inntektTSB;

    /** Ny forventet inntekt for TFB. */
    @GuiPrompt(prompt = "Ny forventet inntekt for barnetillegg fellesbarn")
    private InntektBT inntektTFB;

    public InntektsberegningsResultat() {
    }

    public InntektsberegningsResultat(InntektsberegningsResultat inntektsberegningsResultat) {
        if (inntektsberegningsResultat.inntektTFB != null) {
            inntektTFB = new InntektBT(inntektsberegningsResultat.inntektTFB);
        }

        if (inntektsberegningsResultat.inntektTSB != null) {
            inntektTSB = new InntektBT(inntektsberegningsResultat.inntektTSB);
        }
    }

    public InntektBT getInntektTSB() {
        return inntektTSB;
    }

    public void setInntektTSB(InntektBT inntektTSB) {
        this.inntektTSB = inntektTSB;
    }

    public InntektBT getInntektTFB() {
        return inntektTFB;
    }

    public void setInntektTFB(InntektBT inntektTFB) {
        this.inntektTFB = inntektTFB;
    }

}
