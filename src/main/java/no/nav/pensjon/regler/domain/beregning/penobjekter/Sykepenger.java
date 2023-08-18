package no.nav.pensjon.regler.domain.beregning.penobjekter;

import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

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
