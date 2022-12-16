package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

public class MinstenivatilleggIndividuelt extends Ytelseskomponent {

    private MinstePensjonsniva mpn;
    private Garantipensjonsniva garPN;
    private double samletPensjonForMNT;

    public MinstenivatilleggIndividuelt() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("MIN_NIVA_TILL_INDV");
    }

}
