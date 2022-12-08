package no.nav.domain.pensjon.regler.beregning.penobjekter;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

public class FasteUtgifterTilleggUT extends Ytelseskomponent {
   private Integer nettoAkk;
    private Integer nettoRestAr;
    private Integer avkortningsbelopPerAr;

    public FasteUtgifterTilleggUT() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_FAST_UTGIFT_T");
    }
}
