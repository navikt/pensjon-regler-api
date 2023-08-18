package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.util.DateCompareUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Angir informasjon om stillingsprosent
 * 
 * @author Swiddy de Louw (Capgemini), PK-7973 PKPYTON-526
 */

public class Arbeidsforholdsgrunnlag implements Serializable, Comparable<Arbeidsforholdsgrunnlag> {

    private static final long serialVersionUID = 4588172366522690684L;

    /**
     * Fom dato for arbeidsforholdet.
     */
    private Date fomDato;

    /**
     * Tom dato for arbeidsforholdet.
     */
    private Date tomDato;

    /**
     * Stillingsandel i prosent.
     */
    private int stillingsprosent;

    /**
     * Navn på arbeidsgiver.
     */
    private String arbeidsgiver;

    /**
     * Arbeidsgivers juridiske organisasjonsnummer.
     */
    private String orgNummer;

    public Arbeidsforholdsgrunnlag() {
        super();
    }

    public Arbeidsforholdsgrunnlag(Arbeidsforholdsgrunnlag ag) {
        if (ag.fomDato != null) {
            fomDato = (Date) ag.fomDato.clone();
        }
        if (ag.tomDato != null) {
            tomDato = (Date) ag.tomDato.clone();
        }
        stillingsprosent = ag.stillingsprosent;
        arbeidsgiver = ag.arbeidsgiver;
        orgNummer = ag.orgNummer;
    }

    /**
     * @return the fomDato
     */
    public Date getFomDato() {
        return fomDato;
    }

    /**
     * @param fomDato the fomDato to set
     */
    public void setFomDato(Date fomDato) {
        this.fomDato = fomDato;
    }

    /**
     * @return the tomDato
     */
    public Date getTomDato() {
        return tomDato;
    }

    /**
     * @param tomDato the tomDato to set
     */
    public void setTomDato(Date tomDato) {
        this.tomDato = tomDato;
    }

    /**
     * @return the stillingsprosent
     */
    public int getStillingsprosent() {
        return stillingsprosent;
    }

    /**
     * @param stillingsprosent the stillingsprosent to set
     */
    public void setStillingsprosent(int stillingsprosent) {
        this.stillingsprosent = stillingsprosent;
    }

    /**
     * @return the arbeidsgiver
     */
    public String getArbeidsgiver() {
        return arbeidsgiver;
    }

    /**
     * @param arbeidsgiver the arbeidsgiver to set
     */
    public void setArbeidsgiver(String arbeidsgiver) {
        this.arbeidsgiver = arbeidsgiver;
    }

    /**
     * @return the orgnummer
     */
    public String getOrgNummer() {
        return orgNummer;
    }

    /**
     * @param orgNummer the orgnummer to set
     */
    public void setOrgNummer(String orgNummer) {
        this.orgNummer = orgNummer;
    }

    public int compareTo(Arbeidsforholdsgrunnlag arbeidsforholdsgrunnlag) {
        return DateCompareUtil.compareTo(getFomDato(), arbeidsforholdsgrunnlag.getFomDato());
    }
}
