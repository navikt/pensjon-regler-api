package no.nav.domain.pensjon.regler;

import java.io.Serializable;

public class Yrkesskadeopptjening implements Serializable {
    

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

}
