package no.nav.domain.pensjon.regler.gomregning;

import no.nav.domain.pensjon.regler.grunnlag.Inntektsgrunnlag;

import java.io.Serializable;
import java.util.ArrayList;

public class PersongrunnlagOmregningResultat implements Serializable {

    private Long persongrunnlagId;
    private ArrayList<Inntektsgrunnlag> inntektsgrunnlagResultatListe;


}
