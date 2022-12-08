package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

public class Familietillegg extends Ytelseskomponent {



    public Familietillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("FAM_T");
    }


}
