package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.kode.JustertPeriodeCti;
import no.nav.pensjon.regler.domain.util.DateCompareUtil;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Nabil Safadi (Decisive) - PK-8518
 * @author Øyvind Skytøen (Accenture) - PK-8518
 */

/**
 * Objektet inneholder informasjon om perioder der person har institusjonsopphold som kan medføre reduksjon av pensjon.
 */
public class InstOpphReduksjonsperiode implements Comparable<InstOpphReduksjonsperiode>, Serializable {

    private static final long serialVersionUID = 7344217106754950521L;

    /**
     * Unik identifikasjon av objektet.
     */
    private long instOpphReduksjonsperiodeId;
    /**
     * Fra og med dato
     */
    private Date fom;
    /**
     * Til og med dato
     */
    private Date tom;
    /**
     * Angir om reduksjon er grunnet varighet.
     */
    private boolean reduksjonGrunnetVarighet;
    /**
     * Angir om institusjonsoppholdsperioden medfører en økning eller reduksjon av pensjonsytelsen.
     */
    private JustertPeriodeCti justertPeriodeType;

    /**
     * Angir om bruker har forsørgeransvar ved institusjonsopphold
     */
    private boolean forsorgeransvar;

    /**
     * Copy Constructor
     * 
     * @param instOpphReduksjonsperiode a <code>InstOpphReduksjonsperiode</code> object
     */
    public InstOpphReduksjonsperiode(InstOpphReduksjonsperiode instOpphReduksjonsperiode) {
        instOpphReduksjonsperiodeId = instOpphReduksjonsperiode.instOpphReduksjonsperiodeId;
        if (instOpphReduksjonsperiode.fom != null) {
            fom = (Date) instOpphReduksjonsperiode.fom.clone();
        }
        if (instOpphReduksjonsperiode.tom != null) {
            tom = (Date) instOpphReduksjonsperiode.tom.clone();
        }
        reduksjonGrunnetVarighet = instOpphReduksjonsperiode.reduksjonGrunnetVarighet;
        if (instOpphReduksjonsperiode.justertPeriodeType != null) {
            justertPeriodeType = new JustertPeriodeCti(instOpphReduksjonsperiode.justertPeriodeType);
        }
        forsorgeransvar = instOpphReduksjonsperiode.forsorgeransvar;
    }

    public InstOpphReduksjonsperiode() {
    }

    public InstOpphReduksjonsperiode(long instOpphReduksjonsperiodeId, Date fom, Date tom, boolean reduksjonGrunnetVarighet, JustertPeriodeCti justertPeriodeType) {
        super();
        this.instOpphReduksjonsperiodeId = instOpphReduksjonsperiodeId;
        this.fom = fom;
        this.tom = tom;
        this.reduksjonGrunnetVarighet = reduksjonGrunnetVarighet;
        this.justertPeriodeType = justertPeriodeType;
    }

    public Date getFom() {
        return fom;
    }

    public void setFom(Date fom) {
        this.fom = fom;
    }

    public boolean isForsorgeransvar() {
        return forsorgeransvar;
    }

    public void setForsorgeransvar(boolean forsorgeransvar) {
        this.forsorgeransvar = forsorgeransvar;
    }

    public long getInstOpphReduksjonsperiodeId() {
        return instOpphReduksjonsperiodeId;
    }

    public void setInstOpphReduksjonsperiodeId(long instOpphReduksjonsperiodeId) {
        this.instOpphReduksjonsperiodeId = instOpphReduksjonsperiodeId;
    }

    public boolean isReduksjonGrunnetVarighet() {
        return reduksjonGrunnetVarighet;
    }

    public void setReduksjonGrunnetVarighet(boolean reduksjonGrunnetVarighet) {
        this.reduksjonGrunnetVarighet = reduksjonGrunnetVarighet;
    }

    public Date getTom() {
        return tom;
    }

    public void setTom(Date tom) {
        this.tom = tom;
    }

    public JustertPeriodeCti getJustertPeriodeType() {
        return justertPeriodeType;
    }

    public void setJustertPeriodeType(JustertPeriodeCti justertPeriodeType) {
        this.justertPeriodeType = justertPeriodeType;
    }

    @Override
    public int compareTo(InstOpphReduksjonsperiode iperiode) {

        return DateCompareUtil.compareTo(getFom(), iperiode.getFom());
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

        String retValue = "";

        retValue = "InstOpphReduksjonsperiode ( " + super.toString() + TAB + "instOpphReduksjonsperiodeId = " + instOpphReduksjonsperiodeId + TAB + "fom = " + fom + TAB + "tom = "
                   + tom + TAB + "reduksjonGrunnetVarighet = " + reduksjonGrunnetVarighet + TAB;
        if (justertPeriodeType != null && justertPeriodeType.getKode() != null) {
            retValue += "justertPeriodeType = " + justertPeriodeType.getKode() + TAB;
        }
        retValue += " )";

        return retValue;
    }

}
