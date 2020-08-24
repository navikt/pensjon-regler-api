package no.nav.domain.pensjon.regler.gomregning;

import no.nav.domain.pensjon.regler.BatchStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class KravFaktoromregningResultat implements Serializable {
    private static final long serialVersionUID = -2605928824068483914L;

    private Long kravId;
    private BatchStatus batchStatus;
    private List<PersongrunnlagOmregningResultat> persongrunnlagOmregningResultatListe;

    public KravFaktoromregningResultat(Long kravId, BatchStatus batchStatus, List<PersongrunnlagOmregningResultat> persongrunnlagOmregningResultatListe) {
        super();
        this.kravId = kravId;
        this.batchStatus = batchStatus;
        this.persongrunnlagOmregningResultatListe = persongrunnlagOmregningResultatListe;
    }

    public KravFaktoromregningResultat() {
        persongrunnlagOmregningResultatListe = new ArrayList<PersongrunnlagOmregningResultat>();
    }

    public PersongrunnlagOmregningResultat[] beregningResultatListe() {
        return persongrunnlagOmregningResultatListe.toArray(new PersongrunnlagOmregningResultat[0]);
    }

    public BatchStatus getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(BatchStatus batchStatus) {
        this.batchStatus = batchStatus;
    }

    public Long getKravId() {
        return kravId;
    }

    public void setKravId(Long kravId) {
        this.kravId = kravId;
    }

    public List<PersongrunnlagOmregningResultat> getPersongrunnlagOmregningResultatListe() {
        return persongrunnlagOmregningResultatListe;
    }

    public void setPersongrunnlagOmregningResultatListe(List<PersongrunnlagOmregningResultat> persongrunnlagOmregningResultatListe) {
        this.persongrunnlagOmregningResultatListe = persongrunnlagOmregningResultatListe;
    }

}
