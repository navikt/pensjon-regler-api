package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

public class Garantitillegg extends Ytelseskomponent {


    public Garantitillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("GAT");
    }

    public Garantitillegg(Garantitillegg gt) {
        super(gt);
        ytelsekomponentType = new YtelsekomponentTypeCti("GAT");
    }

}
