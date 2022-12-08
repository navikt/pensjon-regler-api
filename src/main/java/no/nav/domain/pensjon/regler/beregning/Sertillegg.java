package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/*
 * Særtillegget
 */

public class Sertillegg extends Ytelseskomponent {

    

    /**
     * Prosentsatsen
     */
    private double pSats_st;

    private int PREG_orginalBrutto;


    public Sertillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("ST");
    }


}
