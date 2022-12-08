package no.nav.domain.pensjon.regler.beregning.penobjekter;

import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/**
 * Created by N123422 on 06.11.2014.
 */
public class Arbeidsavklaringspenger extends MotregningYtelseskomponent {

    public Arbeidsavklaringspenger() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("AAP");
    }

}
