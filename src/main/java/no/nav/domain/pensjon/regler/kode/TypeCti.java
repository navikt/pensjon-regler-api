package no.nav.domain.pensjon.regler.kode;

import java.io.Serializable;
import java.util.Date;

public class TypeCti implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 7711017918802474490L;

    protected String kode;

    protected String dekode;

    protected Date dato_fom;

    protected Date dato_tom;

    protected boolean er_gyldig;

    protected String kommentar;

    /**
     * Copy Constructor
     * 
     * @param typeCti a <code>TypeCti</code> object
     */
    public TypeCti(TypeCti typeCti) {
        kode = typeCti.kode;
        dekode = typeCti.dekode;
        if (typeCti.dato_fom != null) {
            dato_fom = (Date) typeCti.dato_fom.clone();
        }
        if (typeCti.dato_tom != null) {
            dato_tom = (Date) typeCti.dato_tom.clone();
        }
        er_gyldig = typeCti.er_gyldig;
        kommentar = typeCti.kommentar;
    }

    public TypeCti() {
        super();
    }

    public TypeCti(String kode) {
        super();
        this.kode = kode;
        er_gyldig = true;
    }

    /**
     * @return Returns the dato_fom.
     */
    public Date getDato_fom() {
        return dato_fom;
    }

    /**
     * @param dato_fom The dato_fom to set.
     */
    public void setDato_fom(Date dato_fom) {
        this.dato_fom = dato_fom;
    }

    /**
     * @return Returns the dato_tom.
     */
    public Date getDato_tom() {
        return dato_tom;
    }

    /**
     * @param dato_tom The dato_tom to set.
     */
    public void setDato_tom(Date dato_tom) {
        this.dato_tom = dato_tom;
    }

    /**
     * @return Returns the dekode.
     */
    public String getDekode() {
        return dekode;
    }

    /**
     * @param dekode The dekode to set.
     */
    public void setDekode(String dekode) {
        this.dekode = dekode;
    }

    /**
     * @return Returns the er_gyldig.
     */
    public boolean isEr_gyldig() {
        return er_gyldig;
    }

    /**
     * @param er_gyldig The er_gyldig to set.
     */
    public void setEr_gyldig(boolean er_gyldig) {
        this.er_gyldig = er_gyldig;
    }

    /**
     * @return Returns the kode.
     */
    public String getKode() {
        return kode;
    }

    /**
     * @param kode The kode to set.
     */
    public void setKode(String kode) {
        this.kode = kode;
    }

    /**
     * @return Returns the kommentar.
     */
    public String getKommentar() {
        return kommentar;
    }

    /**
     * @param kommentar The kommentar to set.
     */
    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    /*
     * Simple version to print kode field only.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append(this.getClass().getSimpleName());
        result.append(" { kode: ");
        result.append(kode);
        result.append(" }");
        result.append(newLine);

        return result.toString();
    }
}
