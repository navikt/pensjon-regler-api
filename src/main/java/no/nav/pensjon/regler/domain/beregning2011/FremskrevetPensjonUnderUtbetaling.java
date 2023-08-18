package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.kode.FormelKodeCti;

import java.io.Serializable;

public class FremskrevetPensjonUnderUtbetaling implements Serializable, Regulering {
    private static final long serialVersionUID = 1812360857417648421L;
    private double pensjonUnderUtbetalingPerAr;
    private int gap;
    private double reguleringsfaktor;
    private FormelKodeCti formelKode;

    public FremskrevetPensjonUnderUtbetaling() {
        super();
        setFormelKode(new FormelKodeCti("BPUx"));
    }

    public FremskrevetPensjonUnderUtbetaling(double pensjonUnderUtbetalingPerAr, int gap, double reguleringsfaktor, FormelKodeCti formelKode) {
        super();
        this.pensjonUnderUtbetalingPerAr = pensjonUnderUtbetalingPerAr;
        this.gap = gap;
        this.reguleringsfaktor = reguleringsfaktor;
        this.formelKode = formelKode;

    }

    public FremskrevetPensjonUnderUtbetaling(FremskrevetPensjonUnderUtbetaling fremskrevetPensjonUnderUtbetaling) {
        super();
        pensjonUnderUtbetalingPerAr = fremskrevetPensjonUnderUtbetaling.pensjonUnderUtbetalingPerAr;
        gap = fremskrevetPensjonUnderUtbetaling.gap;
        reguleringsfaktor = fremskrevetPensjonUnderUtbetaling.reguleringsfaktor;
        if (fremskrevetPensjonUnderUtbetaling.formelKode != null) {
            formelKode = new FormelKodeCti(fremskrevetPensjonUnderUtbetaling.formelKode);
        }
    }

    public double getPensjonUnderUtbetalingPerAr() {
        return pensjonUnderUtbetalingPerAr;
    }

    public void setPensjonUnderUtbetalingPerAr(double pensjonUnderUtbetalingPerAr) {
        this.pensjonUnderUtbetalingPerAr = pensjonUnderUtbetalingPerAr;
    }

    @Override
    public int getGap() {
        return gap;
    }

    @Override
    public void setGap(int gap) {
        this.gap = gap;
    }

    @Override
    public double getReguleringsfaktor() {
        return reguleringsfaktor;
    }

    @Override
    public void setReguleringsfaktor(double reguleringsfaktor) {
        this.reguleringsfaktor = reguleringsfaktor;
    }

    public FormelKodeCti getFormelKode() {
        return formelKode;
    }

    public void setFormelKode(FormelKodeCti formelKode) {
        this.formelKode = formelKode;
    }

}
