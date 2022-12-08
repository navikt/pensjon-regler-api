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

    

    private int grunnlagForUtbetaling;


    public TilleggTilHjelpIHuset(int grunnlagForUtbetaling) {
        super();
        this.grunnlagForUtbetaling = grunnlagForUtbetaling;
        ytelsekomponentType = new YtelsekomponentTypeCti("HJELP_I_HUS");
    }


}
