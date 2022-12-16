package no.nav.domain.pensjon.regler.beregning2011;

import java.io.Serializable;

/**
 * @author Steinar Hjellvik (Decisive) - PK-6458
 */
public class UtbetalingsgradUT implements Serializable {


    /**
     * Året utbetalingsgraden gjelder for.
     */
    private int ar;

    /**
     * Utbetalingsgraden hentes fra uforetrygdOrdiner.avkortingsInformasjon.utbetalingsgrad.
     */
    private int utbetalingsgrad;

}
