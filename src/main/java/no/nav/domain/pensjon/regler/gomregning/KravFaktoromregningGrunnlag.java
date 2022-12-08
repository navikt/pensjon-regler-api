package no.nav.domain.pensjon.regler.gomregning;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class KravFaktoromregningGrunnlag implements Serializable {


    private Long kravId;
    private List<PersongrunnlagOmregningGrunnlag> persongrunnlagOmregningGrunnlagListe;

    public KravFaktoromregningGrunnlag(Long kravId, List<PersongrunnlagOmregningGrunnlag> persongrunnlagOmregningGrunnlagListe) {
        super();
        this.kravId = kravId;
        this.persongrunnlagOmregningGrunnlagListe = persongrunnlagOmregningGrunnlagListe;
    }

    public KravFaktoromregningGrunnlag() {
        persongrunnlagOmregningGrunnlagListe = new ArrayList<PersongrunnlagOmregningGrunnlag>();
    }

    public PersongrunnlagOmregningGrunnlag[] persongrunnlagOmregningGrunnlagListeAsArray() {
        return persongrunnlagOmregningGrunnlagListe.toArray(new PersongrunnlagOmregningGrunnlag[0]);
    }

    public Long getKravId() {
        return kravId;
    }

    public void setKravId(Long kravId) {
        this.kravId = kravId;
    }

    public List<PersongrunnlagOmregningGrunnlag> getPersongrunnlagOmregningGrunnlagListe() {
        return persongrunnlagOmregningGrunnlagListe;
    }

    public void setPersongrunnlagOmregningGrunnlagListe(List<PersongrunnlagOmregningGrunnlag> persongrunnlagOmregningGrunnlagListe) {
        this.persongrunnlagOmregningGrunnlagListe = persongrunnlagOmregningGrunnlagListe;
    }

}
