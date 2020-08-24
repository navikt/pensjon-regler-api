package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

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
