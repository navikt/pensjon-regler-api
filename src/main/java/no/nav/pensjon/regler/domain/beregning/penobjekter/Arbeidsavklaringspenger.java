package no.nav.pensjon.regler.domain.beregning.penobjekter;

import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

/**
 * Created by N123422 on 06.11.2014.
 */
public class Arbeidsavklaringspenger extends MotregningYtelseskomponent {

    private static final long serialVersionUID = -3989091567567065294L;

    public Arbeidsavklaringspenger() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("AAP");
    }

    public Arbeidsavklaringspenger(Arbeidsavklaringspenger arbeidsavklaringspenger) {
        super(arbeidsavklaringspenger);
    }
}
