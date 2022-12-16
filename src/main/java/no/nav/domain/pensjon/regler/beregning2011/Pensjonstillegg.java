package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.FormelKodeCti;
import no.nav.domain.pensjon.regler.kode.MinstepenNivaCti;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

public class Pensjonstillegg extends Ytelseskomponent {


    protected double forholdstall67 = 0.0;

    protected double minstepensjonsnivaSats;

    protected MinstepenNivaCti minstepensjonsnivaSatsType;

    protected JustertMinstePensjonsniva justertMinstePensjonsniva;

    public Pensjonstillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("PT");
        setFormelKode(new FormelKodeCti("PenTx"));
    }

}
