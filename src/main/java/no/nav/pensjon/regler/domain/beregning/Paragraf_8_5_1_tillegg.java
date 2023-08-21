package no.nav.pensjon.regler.domain.beregning;

import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

public class Paragraf_8_5_1_tillegg extends Ytelseskomponent {

    private static final long serialVersionUID = -2207020847014733757L;

    public Paragraf_8_5_1_tillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("8_5_1_T");
    }

    public Paragraf_8_5_1_tillegg(int netto) {
        this();
        this.netto = netto;
    }

    public Paragraf_8_5_1_tillegg(Paragraf_8_5_1_tillegg paragraf_8_5_1_tillegg) {
        super(paragraf_8_5_1_tillegg);
    }
}
