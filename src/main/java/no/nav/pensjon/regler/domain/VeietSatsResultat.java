/*
 * Created on Dec 13, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package no.nav.pensjon.regler.domain;

import no.nav.pensjon.regler.domain.util.ToStringUtil;

import java.io.Serializable;

/**
 * @author utvikler
 *         TODO To change the template for this generated type comment go to Window -
 *         Preferences - Java - Code Style - Code Templates
 */
public class VeietSatsResultat implements Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = -9066818373174958542L;

    public int ar;

    public double verdi;

    public VeietSatsResultat() {
        super();
    }

    public VeietSatsResultat(int ar, double verdi) {
        super();
        this.ar = ar;
        this.verdi = verdi;
    }

    /**
     * @return Returns the ar.
     */
    public int getAr() {
        return ar;
    }

    /**
     * @param ar
     *            The ar to set.
     */
    public void setAr(int ar) {
        this.ar = ar;
    }

    /**
     * @return Returns the verdi.
     */
    public double getVerdi() {
        return verdi;
    }

    /**
     * @param verdi
     *            The verdi to set.
     */
    public void setVerdi(double verdi) {
        this.verdi = verdi;
    }

    /*
     * Generic version. Uses reflection to print field names and values.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
