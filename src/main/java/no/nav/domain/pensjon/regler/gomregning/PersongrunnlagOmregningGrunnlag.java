package no.nav.domain.pensjon.regler.gomregning;

import no.nav.domain.pensjon.regler.grunnlag.Inntektsgrunnlag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersongrunnlagOmregningGrunnlag implements Serializable {


    private Long persongrunnlagId;
    private List<Inntektsgrunnlag> inntektsgrunnlagGrunnlagListe;
    private boolean lonnsvekstOmregn;

    public PersongrunnlagOmregningGrunnlag(Long persongrunnlagId, List<Inntektsgrunnlag> inntektsgrunnlagGrunnlagListe, boolean lonnsvekstOmregn) {
        super();
        this.persongrunnlagId = persongrunnlagId;
        this.inntektsgrunnlagGrunnlagListe = inntektsgrunnlagGrunnlagListe;
        this.lonnsvekstOmregn = lonnsvekstOmregn;
    }

    public PersongrunnlagOmregningGrunnlag() {
        inntektsgrunnlagGrunnlagListe = new ArrayList<Inntektsgrunnlag>();
    }

    public Inntektsgrunnlag[] inntektsgrunnlagGrunnlagListeAsArray() {
        return inntektsgrunnlagGrunnlagListe.toArray(new Inntektsgrunnlag[0]);
    }

    public Long getPersongrunnlagId() {
        return persongrunnlagId;
    }

    public void setPersongrunnlagId(Long persongrunnlagId) {
        this.persongrunnlagId = persongrunnlagId;
    }

    public List<Inntektsgrunnlag> getInntektsgrunnlagGrunnlagListe() {
        return inntektsgrunnlagGrunnlagListe;
    }

    public void setInntektsgrunnlagGrunnlagListe(List<Inntektsgrunnlag> inntektsgrunnlagGrunnlagListe) {
        this.inntektsgrunnlagGrunnlagListe = inntektsgrunnlagGrunnlagListe;
    }

    public boolean isLonnsvekstOmregn() {
        return lonnsvekstOmregn;
    }

    public void setLonnsvekstOmregn(boolean lonnsvekstOmregn) {
        this.lonnsvekstOmregn = lonnsvekstOmregn;
    }

}
