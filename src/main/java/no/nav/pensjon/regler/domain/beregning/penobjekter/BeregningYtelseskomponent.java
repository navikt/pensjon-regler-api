package no.nav.pensjon.regler.domain.beregning.penobjekter;

import no.nav.pensjon.regler.domain.beregning.Beregning;
import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent;

/**
 * Created by N123422 on 06.11.2014.
 */
public abstract class BeregningYtelseskomponent extends Ytelseskomponent {

    private static final long serialVersionUID = -3590463254151748326L;

    //Benyttes i PEN domenemodell for MapKey in Beregning.
    private String ytelseKomponentTypeName;

    private Beregning beregning;

    public BeregningYtelseskomponent() {
        super();
    }

    public BeregningYtelseskomponent(BeregningYtelseskomponent beregningYtelseskomponent) {
        super(beregningYtelseskomponent);
        ytelseKomponentTypeName = beregningYtelseskomponent.ytelseKomponentTypeName;
    }

    protected Beregning getBeregning() {
        return beregning;
    }

    protected void setBeregning(Beregning beregning) {
        this.beregning = beregning;
    }
}
