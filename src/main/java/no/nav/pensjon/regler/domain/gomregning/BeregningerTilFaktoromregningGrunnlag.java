package no.nav.pensjon.regler.domain.gomregning;

import no.nav.pensjon.regler.domain.beregning.Beregning;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BeregningerTilFaktoromregningGrunnlag implements Serializable {

    private static final long serialVersionUID = 8234322249653707979L;
    private Long vedtakId;
    private List<Beregning> beregningGrunnlagListe;

    public BeregningerTilFaktoromregningGrunnlag(Long vedtakId, List<Beregning> beregningGrunnlagListe) {
        super();
        this.vedtakId = vedtakId;
        this.beregningGrunnlagListe = beregningGrunnlagListe;
    }

    public BeregningerTilFaktoromregningGrunnlag() {
        beregningGrunnlagListe = new ArrayList<Beregning>();
    }

    public List<Beregning> getBeregningGrunnlagListe() {
        return beregningGrunnlagListe;
    }

    public void setBeregningGrunnlagListe(List<Beregning> beregningGrunnlagListe) {
        this.beregningGrunnlagListe = beregningGrunnlagListe;
    }

    public Long getVedtakId() {
        return vedtakId;
    }

    public void setVedtakId(Long vedtakId) {
        this.vedtakId = vedtakId;
    }
}
