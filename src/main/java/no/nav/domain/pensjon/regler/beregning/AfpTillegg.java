package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

public class AfpTillegg extends Ytelseskomponent {


    public AfpTillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("AFP_T");
    }

}
