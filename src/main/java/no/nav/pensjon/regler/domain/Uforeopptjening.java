package no.nav.pensjon.regler.domain;

import java.io.Serializable;

public class Uforeopptjening implements Serializable {
    private static final long serialVersionUID = -8609815023011330108L;

    /*
     * Bel�p for hva uf�reopptjeningen utgj�r.
     */
    private double belop;
    /*
     * Angir hvorvidt opptjeningen baseres p� en proRata beregnet uf�repensjon.
     */
    private boolean proRataBeregnetUP;
    /*
     * Angir poengtallet som ligger til grunn utregningen.
     */
    private double poengtall;
    /*
     * Uf�repensjonens uf�regrad.
     */
    private int ufg;
    /*
     * Antatt Inntekt.
     */
    private double antattInntekt;
    /*
     * Antatt Inntekt. ProRata variant.
     */
    private double antattInntekt_proRata;
    /*
     * Angir hvor stor andel av opptjeningen kan benyttes i �ret (fra 0.00 til 1.00).
     */
    private double andel_proRata;
    /*
     * Poeng�r teller for proRata br�k.
     */
    private int poengarTeller_proRata;
    /*
     * Poeng�r nevner for proRata br�k.
     */
    private int poengarNevner_proRata;
    /*
     * Antall fremtidige �r, etter avkortning fra evt redFTT.
     */
    private int antFremtidigeAr_proRata;
    /*
     * Angir yrkesskade delen av opptjeningen.
     */
    private Yrkesskadeopptjening yrkesskadeopptjening;

    /**
     * Angir om opptjening er basert p� uf�retrygd (true) eller uf�repensjon (false).
     */
    private boolean uforetrygd;
	
	/**
	* Angir om �rets uf�reopptjening er relatert til uf�reperiode hvor uf�retidspunktet er konvertert fra uf�repensjon.
	*/
	private boolean konvertertUFT;
	
    //private double PREG_ai_up;
    private double PREG_ai_up_gradert;
    private double PREG_ai_up_gradert_proRata;
    private double PREG_ai_up_restGradert;
    private double PREG_ai_up_restGradert_proRata;
    private double PREG_ai_upyp;

    public Uforeopptjening() {

    }

    public Uforeopptjening(double belop, boolean proRataBeregnetUP, double poengtall, int ufg, double antattInntekt, double antattInntekt_proRata, double andel_proRata,
                           int poengarTeller_proRata, int poengarNevner_proRata, int antFremtidigeAr_proRata, Yrkesskadeopptjening yrkesskadeopptjening) {
        super();
        this.belop = belop;
        this.proRataBeregnetUP = proRataBeregnetUP;
        this.poengtall = poengtall;
        this.ufg = ufg;
        this.antattInntekt = antattInntekt;
        this.antattInntekt_proRata = antattInntekt_proRata;
        this.andel_proRata = andel_proRata;
        this.poengarTeller_proRata = poengarTeller_proRata;
        this.poengarNevner_proRata = poengarNevner_proRata;
        this.antFremtidigeAr_proRata = antFremtidigeAr_proRata;
        this.yrkesskadeopptjening = yrkesskadeopptjening;
    }

    public Uforeopptjening(Uforeopptjening uo) {
        belop = uo.belop;
        proRataBeregnetUP = uo.proRataBeregnetUP;
        poengtall = uo.poengtall;
        ufg = uo.ufg;
        antattInntekt = uo.antattInntekt;
        antattInntekt_proRata = uo.antattInntekt_proRata;
        andel_proRata = uo.andel_proRata;
        poengarTeller_proRata = uo.poengarTeller_proRata;
        poengarNevner_proRata = uo.poengarNevner_proRata;
        antFremtidigeAr_proRata = uo.antFremtidigeAr_proRata;
        if (uo.yrkesskadeopptjening != null) {
            yrkesskadeopptjening = new Yrkesskadeopptjening(uo.yrkesskadeopptjening);
        }
        uforetrygd = uo.uforetrygd;
		konvertertUFT = uo.konvertertUFT;
        PREG_ai_up_gradert = uo.PREG_ai_up_gradert;
        PREG_ai_up_gradert_proRata = uo.PREG_ai_up_gradert_proRata;
        PREG_ai_up_restGradert = uo.PREG_ai_up_restGradert;
        PREG_ai_up_restGradert_proRata = uo.PREG_ai_up_restGradert_proRata;
        PREG_ai_upyp = uo.PREG_ai_upyp;
    }

    public double getAndel_proRata() {
        return andel_proRata;
    }

    public void setAndel_proRata(double andel_proRata) {
        this.andel_proRata = andel_proRata;
    }

    public double getAntattInntekt() {
        return antattInntekt;
    }

    public void setAntattInntekt(double antattInntekt) {
        this.antattInntekt = antattInntekt;
    }

    public double getAntattInntekt_proRata() {
        return antattInntekt_proRata;
    }

    public void setAntattInntekt_proRata(double antattInntekt_proRata) {
        this.antattInntekt_proRata = antattInntekt_proRata;
    }

    public int getAntFremtidigeAr_proRata() {
        return antFremtidigeAr_proRata;
    }

    public void setAntFremtidigeAr_proRata(int antFremtidigeAr_proRata) {
        this.antFremtidigeAr_proRata = antFremtidigeAr_proRata;
    }

    public double getBelop() {
        return belop;
    }

    public void setBelop(double belop) {
        this.belop = belop;
    }

    public int getPoengarNevner_proRata() {
        return poengarNevner_proRata;
    }

    public void setPoengarNevner_proRata(int poengarNevner_proRata) {
        this.poengarNevner_proRata = poengarNevner_proRata;
    }

    public int getPoengarTeller_proRata() {
        return poengarTeller_proRata;
    }

    public void setPoengarTeller_proRata(int poengarTeller_proRata) {
        this.poengarTeller_proRata = poengarTeller_proRata;
    }

    public double getPoengtall() {
        return poengtall;
    }

    public void setPoengtall(double poengtall) {
        this.poengtall = poengtall;
    }

    public boolean isProRataBeregnetUP() {
        return proRataBeregnetUP;
    }

    public void setProRataBeregnetUP(boolean proRataBeregnetUP) {
        this.proRataBeregnetUP = proRataBeregnetUP;
    }

    public int getUfg() {
        return ufg;
    }

    public void setUfg(int ufg) {
        this.ufg = ufg;
    }

    public Yrkesskadeopptjening getYrkesskadeopptjening() {
        return yrkesskadeopptjening;
    }

    public void setYrkesskadeopptjening(Yrkesskadeopptjening yrkesskadeopptjening) {
        this.yrkesskadeopptjening = yrkesskadeopptjening;
    }

    public boolean isUforetrygd() {
        return uforetrygd;
    }
	
	public boolean isKonvertertUFT() {
        return konvertertUFT;
    }
	
    public void setUforetrygd(boolean uforetrygd) {
        this.uforetrygd = uforetrygd;
    }
	
	public void setKonvertertUFT(boolean konvertertUFT) {
        this.konvertertUFT = konvertertUFT;
    }
	
    public double getPREG_ai_up_gradert() {
        return PREG_ai_up_gradert;
    }

    public void setPREG_ai_up_gradert(double preg_ai_up_gradert) {
        PREG_ai_up_gradert = preg_ai_up_gradert;
    }

    public double getPREG_ai_up_gradert_proRata() {
        return PREG_ai_up_gradert_proRata;
    }

    public void setPREG_ai_up_gradert_proRata(double rata) {
        PREG_ai_up_gradert_proRata = rata;
    }

    public double getPREG_ai_up_restGradert() {
        return PREG_ai_up_restGradert;
    }

    public void setPREG_ai_up_restGradert(double gradert) {
        PREG_ai_up_restGradert = gradert;
    }

    public double getPREG_ai_up_restGradert_proRata() {
        return PREG_ai_up_restGradert_proRata;
    }

    public void setPREG_ai_up_restGradert_proRata(double gradert_proRata) {
        PREG_ai_up_restGradert_proRata = gradert_proRata;
    }

    public double getPREG_ai_upyp() {
        return PREG_ai_upyp;
    }

    public void setPREG_ai_upyp(double preg_ai_upyp) {
        PREG_ai_upyp = preg_ai_upyp;
    }

}
