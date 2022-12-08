package no.nav.domain.pensjon.regler.beregning2011;

import java.io.Serializable;

public class InntektBT implements Serializable {

    

    /** Ny forventet inntekt */
    private int samletForventetInntekt;

    /** Detaljer rundt søkers andel av ny forventet inntekt. */
    private BeregnetInntekt soker;

    /** Detaljer rundt eps andel av ny forventet inntekt. */
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
