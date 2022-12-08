package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.InntektTypeCti;

import java.io.Serializable;

public class FaktiskInntektsgrunnlag implements Serializable {

    

    /** Akkumulert inntekt hittil i år. */
    private int faktiskeInntekterHittilIAr;

    /** Angir hvilken type inntekt som er akkumulert. */
    private InntektTypeCti inntektType = new InntektTypeCti();

}
