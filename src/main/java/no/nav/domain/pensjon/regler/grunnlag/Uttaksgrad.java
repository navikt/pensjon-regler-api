package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.util.DateCompareUtil;

import java.io.Serializable;
import java.util.Date;

public class Uttaksgrad implements Comparable<Uttaksgrad>, Serializable {

    private static final long serialVersionUID = -8963723653801267710L;
    private Date fomDato;
    private Date tomDato;
    private int uttaksgrad;

    public Uttaksgrad() {
    }

    public Uttaksgrad(Uttaksgrad uttaksgrad) {
        fomDato = uttaksgrad.fomDato;
        tomDato = uttaksgrad.tomDato;
        this.uttaksgrad = uttaksgrad.uttaksgrad;
    }

    /**
     * Sammenligner mht fomDato - nyeste fomDato vinner
     */
    @Override
    public int compareTo(Uttaksgrad grad) {
        return DateCompareUtil.compareTo(getFomDato(), grad.getFomDato());
    }

    public Date getFomDato() {
        return fomDato;
    }

    public void setFomDato(Date fomDato) {
        this.fomDato = fomDato;
    }

    public Date getTomDato() {
        return tomDato;
    }

    public void setTomDato(Date tomDato) {
        this.tomDato = tomDato;
    }

    public int getUttaksgrad() {
        return uttaksgrad;
    }

    public void setUttaksgrad(int uttaksgrad) {
        this.uttaksgrad = uttaksgrad;
    }
}
