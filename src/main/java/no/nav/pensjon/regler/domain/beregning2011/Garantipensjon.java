package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

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
