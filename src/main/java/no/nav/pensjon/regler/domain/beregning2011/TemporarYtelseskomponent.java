package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

public class TemporarYtelseskomponent extends Ytelseskomponent {

    private static final long serialVersionUID = -7329197820447773846L;

    public TemporarYtelseskomponent() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("TEMP");
    }

    public TemporarYtelseskomponent(TemporarYtelseskomponent temporarYtelseskomponent) {
        super(temporarYtelseskomponent);
        ytelsekomponentType = new YtelsekomponentTypeCti("TEMP");
    }
}
