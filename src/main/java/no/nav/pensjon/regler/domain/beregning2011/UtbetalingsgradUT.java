package no.nav.pensjon.regler.domain.beregning2011;



import java.io.Serializable;

/**
 * @author Steinar Hjellvik (Decisive) - PK-6458
 */
public class UtbetalingsgradUT implements Serializable {

    private static final long serialVersionUID = 7172839709917761023L;

    /**
     * Året utbetalingsgraden gjelder for.
     */

    private int ar;

    /**
     * Utbetalingsgraden hentes fra uforetrygdOrdiner.avkortingsInformasjon.utbetalingsgrad.
     */

    private int utbetalingsgrad;

    public UtbetalingsgradUT() {
        super();
    }

    public UtbetalingsgradUT(UtbetalingsgradUT aUtbetalingsgradUT) {
        ar = aUtbetalingsgradUT.ar;
        utbetalingsgrad = aUtbetalingsgradUT.utbetalingsgrad;
    }

    public UtbetalingsgradUT(int ar, int utbetalingsgrad) {
        this.ar = ar;
        this.utbetalingsgrad = utbetalingsgrad;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getUtbetalingsgrad() {
        return utbetalingsgrad;
    }

    public void setUtbetalingsgrad(int utbetalingsgrad) {
        this.utbetalingsgrad = utbetalingsgrad;
    }
}
