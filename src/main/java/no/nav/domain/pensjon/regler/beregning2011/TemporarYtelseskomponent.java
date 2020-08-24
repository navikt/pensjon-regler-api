package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

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
