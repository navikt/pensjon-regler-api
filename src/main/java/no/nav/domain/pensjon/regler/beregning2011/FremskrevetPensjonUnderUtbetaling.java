package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.FormelKodeCti;

import java.io.Serializable;

public class FremskrevetPensjonUnderUtbetaling implements Serializable {
    
    private double pensjonUnderUtbetalingPerAr;
    private int gap;
    private double reguleringsfaktor;
    private FormelKodeCti formelKode;

    public FremskrevetPensjonUnderUtbetaling() {
        super();
        setFormelKode(new FormelKodeCti("BPUx"));
    }

}
