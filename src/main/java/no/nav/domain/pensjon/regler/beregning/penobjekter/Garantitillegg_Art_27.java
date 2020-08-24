package no.nav.domain.pensjon.regler.beregning.penobjekter;

import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

import java.io.Serializable;

/**
 * Brukes kun i BEF270 til G-omregning.
 *
 * @author Andreas Nilsen
 */
public class Garantitillegg_Art_27 extends Ytelseskomponent implements Serializable {

    private static final long serialVersionUID = 1166743804051457863L;

    private Beregning beregning;

    public Garantitillegg_Art_27(Garantitillegg_Art_27 garantitillegg_Art_27) {
        super(garantitillegg_Art_27);
    }

    public Garantitillegg_Art_27() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("GT_NORDISK");
    }

    protected Beregning getBeregning() {
        return beregning;
    }

    protected void setBeregning(Beregning beregning) {
        this.beregning = beregning;
    }
}
