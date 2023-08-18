package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

public class AfpKronetillegg extends Ytelseskomponent {
    private static final long serialVersionUID = -5451157372553547398L;

    public AfpKronetillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("AFP_KRONETILLEGG");
    }

    public AfpKronetillegg(AfpKronetillegg afpKronetillegg) {
        super(afpKronetillegg);
    }

}
