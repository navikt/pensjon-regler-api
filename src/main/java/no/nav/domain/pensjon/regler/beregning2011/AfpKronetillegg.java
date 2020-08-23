package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

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
