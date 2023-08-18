package no.nav.pensjon.regler.domain.beregning;

import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

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
