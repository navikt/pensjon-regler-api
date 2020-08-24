package no.nav.domain.pensjon.regler.beregning.penobjekter;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

import java.io.Serializable;

/**
 * Brukes kun i BEF270 til G-omregning.
 * 
 * @author Andreas Nilsen
 */
public class Garantitillegg_Art_50 extends Ytelseskomponent implements Serializable {

    private static final long serialVersionUID = -6864763512518533121L;

    public Garantitillegg_Art_50(Garantitillegg_Art_50 garantitillegg_Art_50) {
        super(garantitillegg_Art_50);
    }

    public Garantitillegg_Art_50() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("GT_EOS");
    }

}
