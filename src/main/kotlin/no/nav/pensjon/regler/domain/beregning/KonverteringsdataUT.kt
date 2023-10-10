package no.nav.pensjon.regler.domain.beregning

import java.io.Serializable

class KonverteringsdataUT : Serializable {
    /**
     * Verdien av tp_up
     */
    var tpUfor: Int = 0

    /**
     * Verdien av tp_yp
     */
    var tpYrke: Int = 0
}