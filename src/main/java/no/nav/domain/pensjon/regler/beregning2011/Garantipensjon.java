package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

public class Garantipensjon extends Ytelseskomponent {
    private static final long serialVersionUID = 1495797783492118283L;

    public Garantipensjon() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("GAP");
    }

    public Garantipensjon(Garantipensjon garp) {
        super(garp);
        ytelsekomponentType = new YtelsekomponentTypeCti("GAP");
    }
}
