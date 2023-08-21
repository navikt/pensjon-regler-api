package no.nav.pensjon.regler.domain.beregning.penobjekter;

import no.nav.pensjon.regler.domain.beregning.Beregning;
import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

/**
 * Created by N123422 on 07.11.2014.
 */
public class UforetilleggTilAlderspensjon extends Ytelseskomponent {

    private static final long serialVersionUID = -935432884740134849L;

    private Beregning beregning;

    public UforetilleggTilAlderspensjon() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("UFORETILLEGG_AP");
    }

    public UforetilleggTilAlderspensjon(UforetilleggTilAlderspensjon src) {
        super(src);
        beregning = src.beregning;
    }

    public Beregning getBeregning() {
        return beregning;
    }

    public void setBeregning(Beregning beregning) {
        this.beregning = beregning;
    }
}
