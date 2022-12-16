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

}
