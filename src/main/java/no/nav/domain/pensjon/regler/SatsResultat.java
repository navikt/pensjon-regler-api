package no.nav.domain.pensjon.regler;

import java.io.Serializable;
import java.util.Date;

public class SatsResultat implements Comparable<SatsResultat>, Serializable {

    private Date fom;
    private Date tom;
    private double verdi;

    public SatsResultat(SatsResultat satsResultat) {
        if (satsResultat.fom != null) {
            this.fom = (Date)satsResultat.fom.clone();
        }

        if (satsResultat.tom != null) {
            this.tom = (Date)satsResultat.tom.clone();
        }

        this.verdi = satsResultat.verdi;
    }

    public SatsResultat() {
    }

    public SatsResultat(Date fom, Date tom, double verdi) {
        this.fom = fom;
        this.tom = tom;
        this.verdi = verdi;
    }

    public Date getFom() {
        return this.fom;
    }

    public void setFom(Date fom) {
        this.fom = fom;
    }

    public Date getTom() {
        return this.tom;
    }

    public void setTom(Date tom) {
        this.tom = tom;
    }

    public double getVerdi() {
        return this.verdi;
    }

    public void setVerdi(double verdi) {
        this.verdi = verdi;
    }

    public String toString() {
        return this.fom.toString() + " " + this.tom.toString() + " " + this.verdi;
    }

    public int compareTo(SatsResultat satsResultat) {
        if (this.getFom() == null) {
            return satsResultat.getFom() == null ? 0 : -1;
        } else {
            return satsResultat.getFom() == null ? 1 : this.getFom().compareTo(satsResultat.getFom());
        }
    }
}
