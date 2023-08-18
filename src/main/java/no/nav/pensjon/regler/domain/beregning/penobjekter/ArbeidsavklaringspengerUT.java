package no.nav.pensjon.regler.domain.beregning.penobjekter;

import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

/**
 * Created by N123422 on 07.11.2014.
 */
public class ArbeidsavklaringspengerUT extends MotregningYtelseskomponent {

    private static final long serialVersionUID = -4625717954568863949L;

    public ArbeidsavklaringspengerUT() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_AAP");
    }

    public ArbeidsavklaringspengerUT(ArbeidsavklaringspengerUT arbeidsavklaringspengerUT) {
        super(arbeidsavklaringspengerUT);
    }
}
