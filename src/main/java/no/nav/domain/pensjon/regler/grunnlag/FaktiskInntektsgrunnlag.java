package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.InntektTypeCti;
import no.nav.domain.pensjon.regler.util.Copyable;

import java.io.Serializable;

public class FaktiskInntektsgrunnlag implements Serializable, Copyable<FaktiskInntektsgrunnlag> {

    private static final long serialVersionUID = 5534101290290565969L;

    /** Akkumulert inntekt hittil i år. */
    private int faktiskeInntekterHittilIAr;

    /** Angir hvilken type inntekt som er akkumulert. */
    private InntektTypeCti inntektType = new InntektTypeCti();

    public FaktiskInntektsgrunnlag() {
    }

    public FaktiskInntektsgrunnlag(FaktiskInntektsgrunnlag faktiskInntektsgrunnlag) {
        faktiskeInntekterHittilIAr = faktiskInntektsgrunnlag.faktiskeInntekterHittilIAr;
        inntektType = new InntektTypeCti(faktiskInntektsgrunnlag.inntektType);
    }

    public int getFaktiskeInntekterHittilIAr() {
        return faktiskeInntekterHittilIAr;
    }

    public void setFaktiskeInntekterHittilIAr(int faktiskeInntekterHittilIAr) {
        this.faktiskeInntekterHittilIAr = faktiskeInntekterHittilIAr;
    }

    public InntektTypeCti getInntektType() {
        return inntektType;
    }

    public void setInntektType(InntektTypeCti inntektType) {
        this.inntektType = inntektType;
    }

    @Override
    public FaktiskInntektsgrunnlag deepCopy() {
        return new FaktiskInntektsgrunnlag(this);
    }
}
