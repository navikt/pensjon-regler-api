package no.nav.pensjon.regler.domain.beregning2011

import java.io.Serializable

class UtbetalingsgradUT : Serializable {
    /**
     * året utbetalingsgraden gjelder for.
     */
    @JvmField
    var ar = 0

    /**
     * Utbetalingsgraden hentes fra uforetrygdOrdiner.avkortingsInformasjon.utbetalingsgrad.
     */
    var utbetalingsgrad = 0

}