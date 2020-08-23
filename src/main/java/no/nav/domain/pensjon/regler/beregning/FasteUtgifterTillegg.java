package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/**
 * Tillegget for faste utgifter. Brukes ved institusjonsopphold.
 */
public class FasteUtgifterTillegg extends Ytelseskomponent {

    private static final long serialVersionUID = -2607047532936249148L;

    public FasteUtgifterTillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("FAST_UTGIFT_T");
    }

    public FasteUtgifterTillegg(int fasteUtgifter) {
        super();
        netto = fasteUtgifter;
    }

    public FasteUtgifterTillegg(FasteUtgifterTillegg fasteUtgifterTillegg) {
        super(fasteUtgifterTillegg);
    }
}
