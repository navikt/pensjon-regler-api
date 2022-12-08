package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/**
 * Tillegget for faste utgifter. Brukes ved institusjonsopphold.
 */
public class FasteUtgifterTillegg extends Ytelseskomponent {

    

    public FasteUtgifterTillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("FAST_UTGIFT_T");
    }


}
