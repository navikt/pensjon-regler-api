package no.nav.pensjon.regler.domain.grunnlag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Uforehistorikk implements Serializable {

    private static final long serialVersionUID = 8382295821874028509L;

    /**
     * Liste av uføreperioder.
     */
    private List<Uforeperiode> uforeperiodeListe;

    /**
     * Uføregraden pensjonen er blitt fryst fra.
     */
    private int garantigrad;

    /**
     * Yrkesskadegraden pensjonen er blitt fryst fra.
     */
    private int garantigradYrke;

    /**
     * Dato for sist innmeldt i Folketrygden- for fremtidig trygdetid.
     * Lagt inn ifm PENPORT-2222
     */
    private Date sistMedlITrygden;

    /**
     * Ved eksport og ung uføre vil denne listen inneholde uførehistorikk med ung uføre.
     * Intern PREG variabel
     */
    private List<Uforeperiode> PREG_originalUforeperiodeListe;


    /**
     * Copy Constructor
     * 
     * @param uforehistorikk a <code>Uforehistorikk</code> object
     */
    public Uforehistorikk(Uforehistorikk uforehistorikk) {
        uforeperiodeListe = new ArrayList<Uforeperiode>();
        if (uforehistorikk.uforeperiodeListe != null) {
            for (Uforeperiode uforeperiode : uforehistorikk.uforeperiodeListe) {
                uforeperiodeListe.add(new Uforeperiode(uforeperiode));
            }
        }
        garantigrad = uforehistorikk.garantigrad;
        garantigradYrke = uforehistorikk.garantigradYrke;
        sistMedlITrygden = uforehistorikk.sistMedlITrygden;
        PREG_originalUforeperiodeListe = new ArrayList<Uforeperiode>();
        if (uforehistorikk.PREG_originalUforeperiodeListe != null) {
            for (Uforeperiode uforeperiode : uforehistorikk.PREG_originalUforeperiodeListe) {
                PREG_originalUforeperiodeListe.add(new Uforeperiode(uforeperiode));
            }
        }
    }

    public Uforehistorikk(List<Uforeperiode> uforeperiodeListe, int garantigrad, int garantigradYrke, Date sistMedlITrygden) {
        super();
        this.uforeperiodeListe = uforeperiodeListe;
        this.garantigrad = garantigrad;
        this.garantigradYrke = garantigradYrke;
        this.sistMedlITrygden = sistMedlITrygden;
        PREG_originalUforeperiodeListe = new ArrayList<Uforeperiode>();
    }

    public Uforehistorikk() {
        super();
        uforeperiodeListe = new ArrayList<Uforeperiode>();
        PREG_originalUforeperiodeListe = new ArrayList<Uforeperiode>();
    }

    public List<Uforeperiode> getUforeperiodeListe() {
        return uforeperiodeListe;
    }

    public void setUforeperiodeListe(List<Uforeperiode> uforeperiodeListe) {
        this.uforeperiodeListe = uforeperiodeListe;
    }

    public int getGarantigrad() {
        return garantigrad;
    }

    public void setGarantigrad(int garantigrad) {
        this.garantigrad = garantigrad;
    }

    public int getGarantigradYrke() {
        return garantigradYrke;
    }

    public void setGarantigradYrke(int garantigradYrke) {
        this.garantigradYrke = garantigradYrke;
    }

    public Date getSistMedlITrygden() {
        return sistMedlITrygden;
    }

    public void setSistMedlITrygden(Date sistMedlITrygden) {
        this.sistMedlITrygden = sistMedlITrygden;
    }

    public List<Uforeperiode> getPREG_originalUforeperiodeListe() {
        return PREG_originalUforeperiodeListe;
    }

    public void setPREG_originalUforeperiodeListe(List<Uforeperiode> PREG_originalUforeperiodeListe) {
        this.PREG_originalUforeperiodeListe = PREG_originalUforeperiodeListe;
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

        return "Uforehistorikk ( " + super.toString() + TAB + "uforeperiodeListe = " + uforeperiodeListe + TAB + " )";
    }

}
