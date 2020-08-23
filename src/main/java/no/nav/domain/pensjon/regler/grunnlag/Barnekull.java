package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;

public class Barnekull implements Serializable {

    private static final long serialVersionUID = 1952265251225150194L;
    /**
     * Antall barn i kullet.
     */
    int antallBarn;
    /**
     * Angir om persondetaljen brukes som grunnlag på kravet.
     */
    private boolean bruk;

    /**
     * Copy Constructor
     * 
     * @param barnekull a <code>Barnekull</code> object
     */
    public Barnekull(Barnekull barnekull) {
        antallBarn = barnekull.antallBarn;
        bruk = barnekull.bruk;
    }

    public Barnekull(int antallBarn, boolean bruk) {
        super();
        this.antallBarn = antallBarn;
        this.bruk = bruk;
    }

    public Barnekull() {
        super();
        bruk = true;
    }

    public int getAntallBarn() {
        return antallBarn;
    }

    public void setAntallBarn(int antallBarn) {
        this.antallBarn = antallBarn;
    }

    public boolean isBruk() {
        return bruk;
    }

    public void setBruk(boolean bruk) {
        this.bruk = bruk;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     * 
     * @return a <code>String</code> representation
     *         of this object.
     */
    @Override
    public String toString() {
        final String TAB = "    ";

        StringBuilder retValue = new StringBuilder();

        retValue.append("Barnekull ( ").append(super.toString()).append(TAB).append("antallBarn = ").append(antallBarn).append(TAB).append("bruk = ").append(bruk).append(TAB)
                .append(" )");

        return retValue.toString();
    }
}
