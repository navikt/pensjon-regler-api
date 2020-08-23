package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

public class Familietillegg extends Ytelseskomponent {

    private static final long serialVersionUID = 3240461402111906045L;

    public Familietillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("FAM_T");
    }

    public Familietillegg(int familietillegg) {
        this();
        netto = familietillegg;
    }

    public Familietillegg(Familietillegg Familietillegg) {
        super(Familietillegg);
    }
}
