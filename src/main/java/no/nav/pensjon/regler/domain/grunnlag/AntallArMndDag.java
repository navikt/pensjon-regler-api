package no.nav.pensjon.regler.domain.grunnlag;

import java.io.Serializable;

/**
 * @author Lars Hartvigsen (Decisive), PK-5610
 */
public class AntallArMndDag implements Serializable {
    private static final long serialVersionUID = -5275510642212265116L;
    /**
     * Antall år som skal beskrives.
     */
    private int antallAr;
    /**
     * Antall måneder som skal beskrives.
     */
    private int antallMnd;
    /**
     * Antall dager som skal beskrives.
     */
    private int antallDager;

    /**
     * Copy Constructor
     * 
     * @param antallArOgMnd a <code>AntallArOgMnd</code> object
     */
    public AntallArMndDag(AntallArMndDag antallArMndDag) {
        antallAr = antallArMndDag.antallAr;
        antallMnd = antallArMndDag.antallMnd;
        antallDager = antallArMndDag.antallDager;
    }

    public AntallArMndDag() {
        super();
    }

    public AntallArMndDag(int antallAr, int antallMnd, int antallDager) {
        super();
        this.antallAr = antallAr;
        this.antallMnd = antallMnd;
        this.antallDager = antallDager;
    }

    public int getAntallAr() {
        return antallAr;
    }

    public void setAntallAr(int antallAr) {
        this.antallAr = antallAr;
    }

    public int getAntallMnd() {
        return antallMnd;
    }

    public void setAntallMnd(int antallMnd) {
        this.antallMnd = antallMnd;
    }

    public int getAntallDager() {
        return antallDager;
    }

    public void setAntallDager(int antallDager) {
        this.antallDager = antallDager;
    }
}
