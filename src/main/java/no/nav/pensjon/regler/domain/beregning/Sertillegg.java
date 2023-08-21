package no.nav.pensjon.regler.domain.beregning;

import no.nav.pensjon.regler.domain.GuiPrompt;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

/*
 * S�rtillegget
 */

public class Sertillegg extends Ytelseskomponent {

    private static final long serialVersionUID = 8727863071846637233L;

    /**
     * Prosentsatsen
     */
    @GuiPrompt(prompt = "Prosentsats s�rtillegg")
    private double pSats_st;

    private int PREG_orginalBrutto;
    private double PREG_orginalBruttoPerAr;

    /**
     * Copy Constructor
     * 
     * @param sertillegg a <code>Sertillegg</code> object
     */
    public Sertillegg(Sertillegg sertillegg) {
        super(sertillegg);
        pSats_st = sertillegg.pSats_st;
        PREG_orginalBrutto = sertillegg.PREG_orginalBrutto;
        PREG_orginalBruttoPerAr = sertillegg.PREG_orginalBruttoPerAr;
    }

    public Sertillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("ST");
    }

    public Sertillegg(double sats_st) {
        this();
        pSats_st = sats_st;
    }

    public double getPSats_st() {
        return pSats_st;
    }

    public void setPSats_st(double sats_st) {
        pSats_st = sats_st;
    }

    public int getPREG_orginalBrutto() {
        return PREG_orginalBrutto;
    }

    public void setPREG_orginalBrutto(int brutto) {
        PREG_orginalBrutto = brutto;
    }

    public double getPREG_orginalBruttoPerAr() {
        return PREG_orginalBruttoPerAr;
    }

    public void setPREG_orginalBruttoPerAr(double bruttoPerAr) {
        PREG_orginalBruttoPerAr = bruttoPerAr;
    }

}
