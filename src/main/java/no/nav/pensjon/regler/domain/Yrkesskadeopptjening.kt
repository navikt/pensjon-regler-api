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
    private var PREG_ai_yp_proRata = 0.0
    private var PREG_ai_yp_gradert = 0.0
    private var PREG_ai_yp_gradert_proRata = 0.0
}