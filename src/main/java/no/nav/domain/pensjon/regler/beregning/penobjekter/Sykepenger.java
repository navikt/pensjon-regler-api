package no.nav.domain.pensjon.regler.beregning.penobjekter;

import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/**
 * Created by N123422 on 07.11.2014.
 */
public class Sykepenger extends MotregningYtelseskomponent {



    public Sykepenger() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("SP");
    }

}
