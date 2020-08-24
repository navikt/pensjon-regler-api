package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.PenPerson;
import no.nav.domain.pensjon.regler.kode.GrunnlagKildeCti;
import no.nav.domain.pensjon.regler.kode.SivilstandTypeCti;
import no.nav.domain.pensjon.regler.util.ToStringUtil;

import java.io.Serializable;
import java.util.Date;

public class Sivilstand implements Serializable {

    private static final long serialVersionUID = -2552764411230726030L;

    /**
     * Kode som angir hvilken type sivilstand personen har.
     */
    private SivilstandTypeCti sivilstandType;

    /**
     * Sivilstandens gyldighet fra-og-med dato.
     */
    private Date fom;

    /**
     * Sivilstandens gyldighet til-og-med dato
     */
    private Date tom;

    /**
     * Person sivilstanden refererer seg til, for eksempel ektefellen hvis <em>sivilstandType</em>="Ektefelle"
     */
    private PenPerson relatertPerson;

    /**
     * Angir sivilstandens kilde.
     */
    private GrunnlagKildeCti kilde;

    /**
     * Copy Constructor
     * 
     * @param sivilstand a <code>Sivilstand</code> object
     */
    public Sivilstand(Sivilstand sivilstand) {
        if (sivilstand.sivilstandType != null) {
            sivilstandType = new SivilstandTypeCti(sivilstand.sivilstandType);
        }
        if (sivilstand.fom != null) {
            fom = (Date) sivilstand.fom.clone();
        }
        if (sivilstand.tom != null) {
            tom = (Date) sivilstand.tom.clone();
        }
        if (sivilstand.relatertPerson != null) {
            relatertPerson = new PenPerson(sivilstand.relatertPerson);
        }
        if (sivilstand.kilde != null) {
            kilde = new GrunnlagKildeCti(sivilstand.kilde);
        }
    }

    public Sivilstand(SivilstandTypeCti sivilstandType, Date fom, Date tom, PenPerson relatertPerson, GrunnlagKildeCti kilde) {
        super();
        this.sivilstandType = sivilstandType;
        this.fom = fom;
        this.tom = tom;
        this.relatertPerson = relatertPerson;
        this.kilde = kilde;
    }

    public Sivilstand() {
        super();
    }

    public Date getFom() {
        return fom;
    }

    public void setFom(Date fom) {
        this.fom = fom;
    }

    public SivilstandTypeCti getSivilstandType() {
        return sivilstandType;
    }

    public void setSivilstandType(SivilstandTypeCti sivilstandType) {
        this.sivilstandType = sivilstandType;
    }

    public Date getTom() {
        return tom;
    }

    public void setTom(Date tom) {
        this.tom = tom;
    }

    /*
     * Generic version. Uses reflection to print field names and values.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }

    public PenPerson getRelatertPerson() {
        return relatertPerson;
    }

    public void setRelatertPerson(PenPerson relatertPerson) {
        this.relatertPerson = relatertPerson;
    }

    public GrunnlagKildeCti getKilde() {
        return kilde;
    }

    public void setKilde(GrunnlagKildeCti kilde) {
        this.kilde = kilde;
    }
}
