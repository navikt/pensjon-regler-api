package no.nav.pensjon.regler.domain.gomregning;

import no.nav.pensjon.regler.domain.BatchStatus;
import no.nav.pensjon.regler.domain.beregning.Beregning;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BeregningerFaktoromregningResultat implements Serializable {

    private static final long serialVersionUID = 3474082839949693206L;
    private Long vedtakId;
    private BatchStatus batchStatus;
    private List<Beregning> beregningResultatListe;

    public BeregningerFaktoromregningResultat(Long vedtakId, BatchStatus batchStatus, List<Beregning> beregningResultatListe) {
        super();
        this.vedtakId = vedtakId;
        this.batchStatus = batchStatus;
        this.beregningResultatListe = beregningResultatListe;
    }

    public BeregningerFaktoromregningResultat() {
        beregningResultatListe = new ArrayList<Beregning>();
    }

    public Beregning[] beregningResultatListe() {
        return beregningResultatListe.toArray(new Beregning[0]);
    }

    public BatchStatus getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(BatchStatus batchStatus) {
        this.batchStatus = batchStatus;
    }

    public List<Beregning> getBeregningResultatListe() {
        return beregningResultatListe;
    }

    public void setBeregningResultatListe(List<Beregning> beregningResultatListe) {
        this.beregningResultatListe = beregningResultatListe;
    }

    public Long getVedtakId() {
        return vedtakId;
    }

    public void setVedtakId(Long vedtakId) {
        this.vedtakId = vedtakId;
    }
}
