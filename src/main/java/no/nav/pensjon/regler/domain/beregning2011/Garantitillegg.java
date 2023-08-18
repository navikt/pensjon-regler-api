package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

public class Garantitillegg extends Ytelseskomponent {
    private static final long serialVersionUID = -222566587860410921L;

    public Garantitillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("GAT");
    }

    public Garantitillegg(Garantitillegg gt) {
        super(gt);
        ytelsekomponentType = new YtelsekomponentTypeCti("GAT");
    }

}
