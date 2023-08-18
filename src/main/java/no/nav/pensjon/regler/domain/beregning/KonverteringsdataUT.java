package no.nav.pensjon.regler.domain.beregning;

import java.io.Serializable;

/**
 * @author Magnus Bakken (Accenture) PK-9158
 */
public class KonverteringsdataUT implements Serializable {

    private static final long serialVersionUID = 895597202221778381L;
    /**
     * Verdien av tp_up
     */
    private int tpUfor;

    /**
     * Verdien av tp_yp
     */
    private int tpYrke;

    public KonverteringsdataUT() {
        tpUfor = 0;
        tpYrke = 0;
    }

    /**
     * Copy Constructor
     *
     * @param konverteringsdata a <code>KonverteringsdataUT</code> object
     */
    public KonverteringsdataUT(KonverteringsdataUT konverteringsdata) {
        tpUfor = konverteringsdata.tpUfor;
        tpYrke = konverteringsdata.tpYrke;
    }

    public KonverteringsdataUT(int tpUfor, int tpYrke){
        this.tpUfor = tpUfor;
        this.tpYrke = tpYrke;
    }

    public int getTpUfor() {
        return tpUfor;
    }

    public void setTpUfor(int tpUfor) {
        this.tpUfor = tpUfor;
    }

    public int getTpYrke() {
        return tpYrke;
    }

    public void setTpYrke(int tpYrke) {
        this.tpYrke = tpYrke;
    }
}
