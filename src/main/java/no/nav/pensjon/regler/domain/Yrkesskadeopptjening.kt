package no.nav.pensjon.regler.domain

import java.io.Serializable

class Yrkesskadeopptjening : Serializable {
    /*
     * Poeng etter antatt årlig inntekt.
     */
    var paa = 0.0

    /*
     * Yrkesskadegrad.
     */
    var yug = 0

    /*
     * Antatt Inntekt for yrkesskadeopptjeningen.
     */
    var antattInntektYrke = 0.0
}