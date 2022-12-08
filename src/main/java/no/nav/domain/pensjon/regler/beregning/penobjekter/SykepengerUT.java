package no.nav.domain.pensjon.regler.beregning.penobjekter;

import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/**
 * Created by N123422 on 07.11.2014.
 */
public class SykepengerUT extends MotregningYtelseskomponent {



    public SykepengerUT() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_SP");
    }

}
