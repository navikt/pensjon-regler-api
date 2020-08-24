package no.nav.domain.pensjon.regler.beregning.penobjekter;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

import java.io.Serializable;

/**
 * Brukes kun av BEF270 til G-omregning.
 * 
 * @author Andreas Nilsen
 */
public class TilleggTilHjelpIHuset extends Ytelseskomponent implements Serializable {

    private static final long serialVersionUID = -5343502196800156930L;

    private int grunnlagForUtbetaling;

    public TilleggTilHjelpIHuset(TilleggTilHjelpIHuset tilleggTilHjelpIHuset) {
        super(tilleggTilHjelpIHuset);
        grunnlagForUtbetaling = tilleggTilHjelpIHuset.grunnlagForUtbetaling;
    }

    public TilleggTilHjelpIHuset(int grunnlagForUtbetaling) {
        super();
        this.grunnlagForUtbetaling = grunnlagForUtbetaling;
        ytelsekomponentType = new YtelsekomponentTypeCti("HJELP_I_HUS");
    }

    public TilleggTilHjelpIHuset() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("HJELP_I_HUS");
    }

    public int getGrunnlagForUtbetaling() {
        return grunnlagForUtbetaling;
    }

    public void setGrunnlagForUtbetaling(int grunnlagForUtbetaling) {
        this.grunnlagForUtbetaling = grunnlagForUtbetaling;
    }

}
