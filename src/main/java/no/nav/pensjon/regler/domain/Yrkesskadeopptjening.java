package no.nav.pensjon.regler.domain;

import java.io.Serializable;

public class Yrkesskadeopptjening implements Serializable {
    private static final long serialVersionUID = 8195816239382610144L;

    /*
     * Poeng etter antatt årlig inntekt.
     */
    private double paa;
    /*
     * Yrkesskadegrad.
     */
    private int yug;
    /*
     * Antatt Inntekt for yrkesskadeopptjeningen.
     */
    private double antattInntektYrke;
    private double PREG_ai_yp_proRata;
    private double PREG_ai_yp_gradert;
    private double PREG_ai_yp_gradert_proRata;

    public Yrkesskadeopptjening() {

    }

    public Yrkesskadeopptjening(double paa, int yug, double antattInntektYrke) {
        this.paa = paa;
        this.yug = yug;
        this.antattInntektYrke = antattInntektYrke;
    }

    public Yrkesskadeopptjening(Yrkesskadeopptjening yo) {
        paa = yo.paa;
        yug = yo.yug;
        antattInntektYrke = yo.antattInntektYrke;
        PREG_ai_yp_proRata = yo.PREG_ai_yp_proRata;
        PREG_ai_yp_gradert = yo.PREG_ai_yp_gradert;
        PREG_ai_yp_gradert_proRata = yo.PREG_ai_yp_gradert_proRata;
    }

    public double getAntattInntektYrke() {
        return antattInntektYrke;
    }

    public void setAntattInntektYrke(double antattInntektYrke) {
        this.antattInntektYrke = antattInntektYrke;
    }

    public double getPaa() {
        return paa;
    }

    public void setPaa(double paa) {
        this.paa = paa;
    }

    public int getYug() {
        return yug;
    }

    public void setYug(int yug) {
        this.yug = yug;
    }

    public double getPREG_ai_yp_gradert() {
        return PREG_ai_yp_gradert;
    }

    public void setPREG_ai_yp_gradert(double preg_ai_yp_gradert) {
        PREG_ai_yp_gradert = preg_ai_yp_gradert;
    }

    public double getPREG_ai_yp_gradert_proRata() {
        return PREG_ai_yp_gradert_proRata;
    }

    public void setPREG_ai_yp_gradert_proRata(double rata) {
        PREG_ai_yp_gradert_proRata = rata;
    }

    public double getPREG_ai_yp_proRata() {
        return PREG_ai_yp_proRata;
    }

    public void setPREG_ai_yp_proRata(double rata) {
        PREG_ai_yp_proRata = rata;
    }

}
