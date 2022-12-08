package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

public class AfpKronetillegg extends Ytelseskomponent {
    

    public AfpKronetillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("AFP_KRONETILLEGG");
    }


}
