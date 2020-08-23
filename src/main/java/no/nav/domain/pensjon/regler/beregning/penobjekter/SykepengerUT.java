package no.nav.domain.pensjon.regler.beregning.penobjekter;

import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/**
 * Created by N123422 on 07.11.2014.
 */
public class SykepengerUT extends MotregningYtelseskomponent {

    private static final long serialVersionUID = -7349919706373834939L;

    public SykepengerUT() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_SP");
    }

    public SykepengerUT(SykepengerUT sykepengerUT) {
        super(sykepengerUT);
    }
}
