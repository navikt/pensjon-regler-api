package no.nav.domain.pensjon.regler.beregning.penobjekter;

import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/**
 * Created by N123422 on 07.11.2014.
 */
public class Sykepenger extends MotregningYtelseskomponent {

    private static final long serialVersionUID = 715401119582214508L;

    public Sykepenger() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("SP");
    }

    public Sykepenger(Sykepenger sykepenger) {
        super(sykepenger);
    }
}
