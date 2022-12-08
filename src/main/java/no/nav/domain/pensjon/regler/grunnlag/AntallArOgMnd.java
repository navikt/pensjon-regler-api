package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;

public class AntallArOgMnd implements Serializable {


    /**
     * Antall år som skal beskrives.
     */
    private int antallAr;
    /**
     * Antall måneder som skal beskrives.
     */
    private int antallMnd;

    /**
     * Copy Constructor
     * 
     * @param antallArOgMnd a <code>AntallArOgMnd</code> object
     */
    public AntallArOgMnd(AntallArOgMnd antallArOgMnd) {
        antallAr = antallArOgMnd.antallAr;
        antallMnd = antallArOgMnd.antallMnd;
    }

    public AntallArOgMnd() {
        super();
    }

    public AntallArOgMnd(int antallAr, int antallMnd) {
        super();
        this.antallAr = antallAr;
        this.antallMnd = antallMnd;
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

}
