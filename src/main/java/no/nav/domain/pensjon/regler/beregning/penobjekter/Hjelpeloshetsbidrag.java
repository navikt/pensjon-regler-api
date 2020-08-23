package no.nav.domain.pensjon.regler.beregning.penobjekter;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

import java.io.Serializable;

/**
 * Brukes kun i BEF270 til G-omregning.
 * 
 * @author Andreas Nilsen
 */
public class Hjelpeloshetsbidrag extends Ytelseskomponent implements Serializable {

    private static final long serialVersionUID = -4000631814950605608L;

    private int grunnlagForUtbetaling;

    public Hjelpeloshetsbidrag(Hjelpeloshetsbidrag hjelpeloshetsbidrag) {
        super(hjelpeloshetsbidrag);
        grunnlagForUtbetaling = hjelpeloshetsbidrag.grunnlagForUtbetaling;
    }

    public Hjelpeloshetsbidrag(int grunnlagForUtbetaling) {
        super();
        this.grunnlagForUtbetaling = grunnlagForUtbetaling;
        ytelsekomponentType = new YtelsekomponentTypeCti("HJELP_BIDRAG");
    }

    public Hjelpeloshetsbidrag() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("HJELP_BIDRAG");
    }

    public int getGrunnlagForUtbetaling() {
        return grunnlagForUtbetaling;
    }

    public void setGrunnlagForUtbetaling(int grunnlagForUtbetaling) {
        this.grunnlagForUtbetaling = grunnlagForUtbetaling;
    }

}
