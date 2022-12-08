package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

public class AfpKompensasjonstillegg extends Ytelseskomponent {

    private int referansebelop;
    private int reduksjonsbelop;
    private double forholdstallKompensasjonstillegg;


    public AfpKompensasjonstillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("AFP_KOMP_TILLEGG");
    }

}
