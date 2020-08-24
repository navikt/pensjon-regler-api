package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.LandCti;

import java.io.Serializable;
import java.util.Date;

public class Utenlandsopphold implements Serializable {
    private static final long serialVersionUID = 2460669269502790696L;
    /**
     * Fra og med dato
     */
    private Date fom;
    /**
     * Til og med dato
     */
    private Date tom;
    /**
     * Landet hvor oppholdet har funnet sted
     */
    private LandCti land;
    /**
     * Hvilken pensjonsordning som skal brukes
     */
    private String pensjonsordning;
    /**
     * Har personen bodd i utlandet
     */
    private boolean bodd;
    /**
     * Har personen arbeidet i utlandet
     */
    private boolean arbeidet;

    /**
     * Copy Constructor
     * 
     * @param utenlandsopphold a <code>Utenlandsopphold</code> object
     */
    public Utenlandsopphold(Utenlandsopphold utenlandsopphold) {
        if (utenlandsopphold.fom != null) {
            fom = (Date) utenlandsopphold.fom.clone();
        }
        if (utenlandsopphold.tom != null) {
            tom = (Date) utenlandsopphold.tom.clone();
        }
        if (utenlandsopphold.land != null) {
            land = new LandCti(utenlandsopphold.land);
        }
        pensjonsordning = utenlandsopphold.pensjonsordning;
        bodd = utenlandsopphold.bodd;
        arbeidet = utenlandsopphold.arbeidet;
    }

    public Utenlandsopphold() {
        super();
    }

    public Utenlandsopphold(Date fom, Date tom, LandCti land, String pensjonsordning, boolean bodd, boolean arbeidet) {
        super();
        this.fom = fom;
        this.tom = tom;
        this.land = land;
        this.pensjonsordning = pensjonsordning;
        this.bodd = bodd;
        this.arbeidet = arbeidet;
    }

    public boolean isArbeidet() {
        return arbeidet;
    }

    public void setArbeidet(boolean arbeidet) {
        this.arbeidet = arbeidet;
    }

    public boolean isBodd() {
        return bodd;
    }

    public void setBodd(boolean bodd) {
        this.bodd = bodd;
    }

    public Date getFom() {
        return fom;
    }

    public void setFom(Date fom) {
        this.fom = fom;
    }

    public LandCti getLand() {
        return land;
    }

    public void setLand(LandCti land) {
        this.land = land;
    }

    public String getPensjonsordning() {
        return pensjonsordning;
    }

    public void setPensjonsordning(String pensjonsordning) {
        this.pensjonsordning = pensjonsordning;
    }

    public Date getTom() {
        return tom;
    }

    public void setTom(Date tom) {
        this.tom = tom;
    }

}
