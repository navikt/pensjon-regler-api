package no.nav.pensjon.regler.domain.beregning;

import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

public class AfpTillegg extends Ytelseskomponent {

    private static final long serialVersionUID = -8986405690692738433L;

    public AfpTillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("AFP_T");
    }

    public AfpTillegg(AfpTillegg afpTillegg) {
        super(afpTillegg);
        ytelsekomponentType = new YtelsekomponentTypeCti("AFP_T");
    }
}
