package no.nav.domain.pensjon.regler.gomregning;

import no.nav.domain.pensjon.regler.grunnlag.Inntektsgrunnlag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersongrunnlagOmregningGrunnlag implements Serializable {


    private Long persongrunnlagId;
    private List<Inntektsgrunnlag> inntektsgrunnlagGrunnlagListe;
    private boolean lonnsvekstOmregn;


}
