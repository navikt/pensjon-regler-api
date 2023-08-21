package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.util.DateCompareUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Objektet inneholder informasjon om den månedlige faste utgiften en bruker har hatt i forbindelse med
 * opphold på en institusjon. Det inneholder også tidsrommet brukeren var innlagt.
 */
public class InstOpphFasteUtgifterperiode implements Comparable<InstOpphFasteUtgifterperiode>, Serializable {

    private static final long serialVersionUID = 3900748094775913361L;
    //	instOpphFasteUtgifterperiodeId	long	Unik identifikasjon av objektet.
    //	fomDato	Date	Dato bruker ble innlagt
    //	tomDato	Date	Dato bruker ble skrevet ut.
    //	fasteUtgifter	int	Månedlig fast utgift bruker hadde på 

    /**
     * Unik identifikasjon av objektet
     */
    private long instOpphFasteUtgifterperiodeId;
    /**
     * Dato bruker ble innlagt
     */
    private Date fom;
    /**
     * Dato bruker ble skrevet ut
     */
    private Date tom;
    /**
     * Månedlig fast utgift bruker hadde på institusjonen
     */
    private int fasteUtgifter;

    /**
     * Copy Constructor
     * 
     * @param instOpphFasteUtgifterperiode a <code>InstOpphFasteUtgifterperiode</code> object
     */
    public InstOpphFasteUtgifterperiode(InstOpphFasteUtgifterperiode instOpphFasteUtgifterperiode) {
        instOpphFasteUtgifterperiodeId = instOpphFasteUtgifterperiode.instOpphFasteUtgifterperiodeId;
        if (instOpphFasteUtgifterperiode.fom != null) {
            fom = (Date) instOpphFasteUtgifterperiode.fom.clone();
        }
        if (instOpphFasteUtgifterperiode.tom != null) {
            tom = (Date) instOpphFasteUtgifterperiode.tom.clone();
        }
        fasteUtgifter = instOpphFasteUtgifterperiode.fasteUtgifter;
    }

    public InstOpphFasteUtgifterperiode(long instOpphFasteUtgifterperiodeId, Date fom, Date tom, int fasteUtgifter) {
        super();
        this.instOpphFasteUtgifterperiodeId = instOpphFasteUtgifterperiodeId;
        this.fom = fom;
        this.tom = tom;
        this.fasteUtgifter = fasteUtgifter;
    }

    public InstOpphFasteUtgifterperiode() {
    }

    public int getFasteUtgifter() {
        return fasteUtgifter;
    }

    public void setFasteUtgifter(int fasteUtgifter) {
        this.fasteUtgifter = fasteUtgifter;
    }

    public Date getFom() {
        return fom;
    }

    public void setFom(Date fom) {
        this.fom = fom;
    }

    public long getInstOpphFasteUtgifterperiodeId() {
        return instOpphFasteUtgifterperiodeId;
    }

    public void setInstOpphFasteUtgifterperiodeId(long instOpphFasteUtgifterperiodeId) {
        this.instOpphFasteUtgifterperiodeId = instOpphFasteUtgifterperiodeId;
    }

    public Date getTom() {
        return tom;
    }

    public void setTom(Date tom) {
        this.tom = tom;
    }

    @Override
    public int compareTo(InstOpphFasteUtgifterperiode iperiode) {
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

        retValue = "InstOpphFasteUtgifterperiode ( " + super.toString() + TAB + "instOpphFasteUtgifterperiodeId = " + instOpphFasteUtgifterperiodeId + TAB + "fom = " + fom + TAB
                   + "tom = " + tom + TAB + "fasteUtgifter = " + fasteUtgifter + TAB + " )";

        return retValue;
    }

}
