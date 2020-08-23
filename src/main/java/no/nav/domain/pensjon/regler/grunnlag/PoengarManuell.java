package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.AvtalelandCti;
import no.nav.domain.pensjon.regler.util.DateCompareUtil;
import no.nav.domain.pensjon.regler.util.ToStringUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Klassen beskriver et poengår opptjent i utlandet. Settes av saksbehandler.
 */
public class PoengarManuell implements Comparable<PoengarManuell>, Serializable {

    private static final long serialVersionUID = -2570460417412503568L;

    /**
     * Poengåret fra og med dato.
     */
    private Date fom;

    /**
     * Poengåret til og med dato.
     */
    private Date tom;

    /**
     * Angir om poengåret skal brukes i pro rata beregning.
     */
    private boolean ikkeProrata;

    /**
     * Angir om poengåret skal brukes i alternativ pro rata beregning.
     */
    private boolean ikkeAlternativProrata;

    /**
     * Avtaleland som poengår ble opptjent i.
     */
    private AvtalelandCti avtaleland;

    /**
     * Copy Constructor
     * 
     * @param poengarManuell a <code>PoengarManuell</code> object
     */
    public PoengarManuell(PoengarManuell poengarManuell) {
        if (poengarManuell.fom != null) {
            fom = (Date) poengarManuell.fom.clone();
        }
        if (poengarManuell.tom != null) {
            tom = (Date) poengarManuell.tom.clone();
        }
        ikkeProrata = poengarManuell.ikkeProrata;
        ikkeAlternativProrata = poengarManuell.ikkeAlternativProrata;
        avtaleland = poengarManuell.avtaleland;
    }

    public PoengarManuell(Date fom, Date tom, boolean ikkeProrata, boolean ikkeAlternativProrata) {
        super();
        this.fom = fom;
        this.tom = tom;
        this.ikkeProrata = ikkeProrata;
        this.ikkeAlternativProrata = ikkeAlternativProrata;
    }

    public PoengarManuell(Date fom, Date tom, boolean ikkeProrata, boolean ikkeAlternativProrata, AvtalelandCti avtaleLand) {
        super();
        this.fom = fom;
        this.tom = tom;
        this.ikkeProrata = ikkeProrata;
        this.ikkeAlternativProrata = ikkeAlternativProrata;
        avtaleland = avtaleLand;
    }

    public PoengarManuell() {
        super();
    }

    /*
     * Generic version. Uses reflection to print field names and values.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }

    public Date getFom() {
        return fom;
    }

    public void setFom(Date fom) {
        this.fom = fom;
    }

    public boolean isIkkeAlternativProrata() {
        return ikkeAlternativProrata;
    }

    public void setIkkeAlternativProrata(boolean ikkeAlternativProrata) {
        this.ikkeAlternativProrata = ikkeAlternativProrata;
    }

    public boolean isIkkeProrata() {
        return ikkeProrata;
    }

    public void setIkkeProrata(boolean ikkeProrata) {
        this.ikkeProrata = ikkeProrata;
    }

    public Date getTom() {
        return tom;
    }

    public void setTom(Date tom) {
        this.tom = tom;
    }

    public AvtalelandCti getAvtaleland() {
        return avtaleland;
    }

    public void setAvtaleland(AvtalelandCti avtaleland) {
        this.avtaleland = avtaleland;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(PoengarManuell poengar) {
        return DateCompareUtil.compareTo(getFom(), poengar.getFom());
    }
}
