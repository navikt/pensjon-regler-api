package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.util.DateCompareUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Lars Hartviksen (Decisive), PK-6985
 * @author Aasmund Nordstoga (Accenture) - PK-16378, PKPYTON-1754
 */
public class ArbeidsforholdEtterUforgrunnlag implements Serializable, Comparable<ArbeidsforholdEtterUforgrunnlag> {
    private static final long serialVersionUID = 6270045905274527907L;

    /**
     * Fom date for arbeidsforholdet.
     */
    private Date fomDato;

    /**
     * Work load.
     */
    private int stillingsprosent;

    /**
     * if it is lasting facilitated work
     */
    private boolean varigTilrettelagtArbeid;

    public ArbeidsforholdEtterUforgrunnlag() {
        super();
    }

    public ArbeidsforholdEtterUforgrunnlag(ArbeidsforholdEtterUforgrunnlag arbeidsforholdEtterUforgrunnlag) {
        if (arbeidsforholdEtterUforgrunnlag.fomDato != null) {
            this.fomDato = arbeidsforholdEtterUforgrunnlag.getFomDato();
        }
        this.stillingsprosent = arbeidsforholdEtterUforgrunnlag.getStillingsprosent();
        this.varigTilrettelagtArbeid = arbeidsforholdEtterUforgrunnlag.isVarigTilrettelagtArbeid();
    }

    /**
     * @return the start date
     */
    public Date getFomDato() {
        return fomDato;
    }

    /**
     * @return fomDato the start date to set
     */
    public void setFomDato(Date fomDato) {
        this.fomDato = fomDato;
    }

    /**
     * @return the work load
     */
    public int getStillingsprosent() {
        return stillingsprosent;
    }

    /**
     * @param stillingsprosent the work load to set
     */
    public void setStillingsprosent(int stillingsprosent) {
        this.stillingsprosent = stillingsprosent;
    }

    /**
     * @return if it is lasting facilitated work
     */
    public boolean isVarigTilrettelagtArbeid() {
        return varigTilrettelagtArbeid;
    }

    /**
     * @param varigTilrettelagtArbeid if it is lasting facilitated work
     */
    public void setVarigTilrettelagtArbeid(boolean varigTilrettelagtArbeid) {
        this.varigTilrettelagtArbeid = varigTilrettelagtArbeid;
    }

    public int compareTo(ArbeidsforholdEtterUforgrunnlag arbeidsforholdEtterUforgrunnlag) {
        return DateCompareUtil.compareTo(getFomDato(), arbeidsforholdEtterUforgrunnlag.getFomDato());
    }
}