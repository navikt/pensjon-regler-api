package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

public class Garantipensjon extends Ytelseskomponent {


    public Garantipensjon() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("GAP");
    }

    public Garantipensjon(Garantipensjon garp) {
        super(garp);
        ytelsekomponentType = new YtelsekomponentTypeCti("GAP");
    }
}
