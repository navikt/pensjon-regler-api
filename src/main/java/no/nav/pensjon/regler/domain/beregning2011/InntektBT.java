package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.GuiPrompt;

import java.io.Serializable;

public class InntektBT implements Serializable {

    private static final long serialVersionUID = 8675592913035533480L;

    /** Ny forventet inntekt */
    @GuiPrompt(prompt = "Ny forventet inntekt")
    private int samletForventetInntekt;

    /** Detaljer rundt s�kers andel av ny forventet inntekt. */
    @GuiPrompt(prompt = "Detaljer rundt s�kers andel av ny forventet inntekt")
    private BeregnetInntekt soker;

    /** Detaljer rundt eps andel av ny forventet inntekt. */
    @GuiPrompt(prompt = "Detaljer rundt eps andel av ny forventet inntekt")
    private BeregnetInntekt eps;

    public InntektBT() {
    }

    public InntektBT(InntektBT inntektBT) {
        samletForventetInntekt = inntektBT.samletForventetInntekt;

        if (inntektBT.soker != null) {
            soker = new BeregnetInntekt(inntektBT.soker);
        }

        if (inntektBT.eps != null) {
            eps = new BeregnetInntekt(inntektBT.eps);
        }

    }

    public int getSamletForventetInntekt() {
        return samletForventetInntekt;
    }

    public void setSamletForventetInntekt(int samletForventetInntekt) {
        this.samletForventetInntekt = samletForventetInntekt;
    }

    public BeregnetInntekt getSoker() {
        return soker;
    }

    public void setSoker(BeregnetInntekt soker) {
        this.soker = soker;
    }

    public BeregnetInntekt getEps() {
        return eps;
    }

    public void setEps(BeregnetInntekt eps) {
        this.eps = eps;
    }

}
