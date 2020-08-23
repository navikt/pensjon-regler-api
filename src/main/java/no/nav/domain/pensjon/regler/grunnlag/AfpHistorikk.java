package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.AfpOrdningTypeCti;
import no.nav.domain.pensjon.regler.util.DateCompareUtil;

import java.io.Serializable;
import java.util.Date;

public class AfpHistorikk implements Serializable, Comparable<AfpHistorikk> {

    private static final long serialVersionUID = -5642856440736488363L;
    /**
     * Fremtidig pensjonspoeng
     */
    private double afpFpp;

    private Date virkFom;

    private Date virkTom;

    private int afpPensjonsgrad;

    private AfpOrdningTypeCti afpOrdning;

    /**
     * Copy Constructor
     * 
     * @param afpHistorikk a <code>AfpHistorikk</code> object
     */
    public AfpHistorikk(AfpHistorikk afpHistorikk) {
        afpFpp = afpHistorikk.afpFpp;
        if (afpHistorikk.virkFom != null) {
            virkFom = (Date) afpHistorikk.virkFom.clone();
        }
        if (afpHistorikk.virkTom != null) {
            virkTom = (Date) afpHistorikk.virkTom.clone();
        }
        afpPensjonsgrad = afpHistorikk.afpPensjonsgrad;
        if (afpHistorikk.afpOrdning != null) {
            afpOrdning = new AfpOrdningTypeCti(afpHistorikk.afpOrdning);
        }
    }

    public AfpHistorikk() {
        super();
    }

    public AfpHistorikk(double afpFpp, Date virkFom, Date virkTom, int afpPensjonsgrad, AfpOrdningTypeCti afpOrdning) {
        super();
        this.afpFpp = afpFpp;
        this.virkFom = virkFom;
        this.virkTom = virkTom;
        this.afpPensjonsgrad = afpPensjonsgrad;
        this.afpOrdning = afpOrdning;
    }

    public double getAfpFpp() {
        return afpFpp;
    }

    public void setAfpFpp(double afpFpp) {
        this.afpFpp = afpFpp;
    }

    public AfpOrdningTypeCti getAfpOrdning() {
        return afpOrdning;
    }

    public void setAfpOrdning(AfpOrdningTypeCti afpOrdning) {
        this.afpOrdning = afpOrdning;
    }

    public int getAfpPensjonsgrad() {
        return afpPensjonsgrad;
    }

    public void setAfpPensjonsgrad(int afpPensjonsgrad) {
        this.afpPensjonsgrad = afpPensjonsgrad;
    }

    public Date getVirkFom() {
        return virkFom;
    }

    public void setVirkFom(Date virkFom) {
        this.virkFom = virkFom;
    }

    public Date getVirkTom() {
        return virkTom;
    }

    public void setVirkTom(Date virkTom) {
        this.virkTom = virkTom;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(AfpHistorikk afpHistorikk) {
        return DateCompareUtil.compareTo(getVirkFom(), afpHistorikk.getVirkFom());
    }
}
