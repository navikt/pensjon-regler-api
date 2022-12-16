package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

public class Skjermingstillegg extends Ytelseskomponent {



    private Double ft67Soker;

    private Double skjermingsgrad;

    private Integer ufg;

    private Double basGp_bruttoPerAr;

    private Double basTp_bruttoPerAr;

    private Double basPenT_bruttoPerAr;

    public Skjermingstillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("SKJERMT");
    }


}
