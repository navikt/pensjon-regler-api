package no.nav.pensjon.regler.domain.beregning2011;



import java.io.Serializable;
import java.util.Date;

public class LonnsvekstInformasjon implements Serializable {
    private static final long serialVersionUID = -979400824825729782L;


    private double lonnsvekst;


    private Date reguleringsDato;


    private int uttaksgradVedRegulering;

    public LonnsvekstInformasjon() {
        super();
    }

    public LonnsvekstInformasjon(LonnsvekstInformasjon li) {
        this();
        lonnsvekst = li.lonnsvekst;
        if (li.reguleringsDato != null) {
            reguleringsDato = li.reguleringsDato;
        }
        uttaksgradVedRegulering = li.uttaksgradVedRegulering;
    }

    /**
     * @return the lonnsvekst
     */
    public double getLonnsvekst() {
        return lonnsvekst;
    }

    /**
     * @param lonnsvekst the lonnsvekst to set
     */
    public void setLonnsvekst(double lonnsvekst) {
        this.lonnsvekst = lonnsvekst;
    }

    /**
     * @return the reguleringsDato
     */
    public Date getReguleringsDato() {
        return reguleringsDato;
    }

    /**
     * @param reguleringsDato the reguleringsDato to set
     */
    public void setReguleringsDato(Date reguleringsDato) {
        this.reguleringsDato = reguleringsDato;
    }

    /**
     * @return the uttaksgradVedRegulering
     */
    public int getUttaksgradVedRegulering() {
        return uttaksgradVedRegulering;
    }

    /**
     * @param uttaksgradVedRegulering the uttaksgradVedRegulering to set
     */
    public void setUttaksgradVedRegulering(int uttaksgradVedRegulering) {
        this.uttaksgradVedRegulering = uttaksgradVedRegulering;
    }

}
