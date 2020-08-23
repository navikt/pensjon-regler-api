package no.nav.domain.pensjon.regler.afpoppgjor;

import no.nav.domain.pensjon.regler.util.DateCompareUtil;

import java.io.Serializable;
import java.util.Date;

public class AfpUtbetalingsperiode implements Comparable<AfpUtbetalingsperiode>, Serializable {

    private static final long serialVersionUID = 7141874928441545244L;

    /**
     * Periodens fradato - not null
     */
    private Date virkFom;
    /**
     * Periodens tildato
     */
    private Date virkTom;
    /**
     * Brutto månedlig AFP i perioden
     */
    private int fullAFP;
    /**
     * Utbetalt månedlig AFP i perioden
     */
    private int utbetaltAFP;
    /**
     * Forventet inntekt i perioden
     * (årlig FPI / 12 * antall måneder i perioden)
     */
    private int fpi;

    /**
     * Tidligere pensjonsgivende inntekts faktor
     */
    private double tpi_faktor;
    /**
     * Graden av utbetalt pensjon i forhold til brtto pensjon
     */
    private int afpPensjonsgrad;
	
	
	/**
	* Objekt som inneholder informasjon om TP-ordningers uførepensjonsgrunnlag. Dette er manuelt registrerte data og ikke hentet fra TP-registeret eller andre eksterne kilder.
	*/
	private no.nav.domain.pensjon.regler.grunnlag.AfpTpoUpGrunnlag AfpTpoUpGrunnlag;
	
	/**
	* Flagg som sier om UP-grunnlaget fra TPO er benyttet i beregning. Brukes for å bestemme om UP-grunnlaget skal benyttes i etteroppgjørsberegningen.
	*/
	private boolean AfpTpoUpGrunnlagAnvendt;

    public AfpUtbetalingsperiode(Date virkFom, Date virkTom, int fullAFP, int utbetaltAFP, int fpi, double tpi_faktor, int afpPensjonsgrad, no.nav.domain.pensjon.regler.grunnlag.AfpTpoUpGrunnlag AfpTpoUpGrunnlag, boolean AfpTpoUpGrunnlagAnvendt) {
        super();
        this.virkFom = virkFom;
        this.virkTom = virkTom;
        this.fullAFP = fullAFP;
        this.utbetaltAFP = utbetaltAFP;
        this.fpi = fpi;
        this.tpi_faktor = tpi_faktor;
        this.afpPensjonsgrad = afpPensjonsgrad;
		this.AfpTpoUpGrunnlag = AfpTpoUpGrunnlag;
		this.AfpTpoUpGrunnlagAnvendt = AfpTpoUpGrunnlagAnvendt;
		
    }

    public AfpUtbetalingsperiode() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getAfpPensjonsgrad() {
        return afpPensjonsgrad;
    }

    public void setAfpPensjonsgrad(int afpPensjonsgrad) {
        this.afpPensjonsgrad = afpPensjonsgrad;
    }

    public int getFpi() {
        return fpi;
    }

    public void setFpi(int fpi) {
        this.fpi = fpi;
    }

    public int getFullAFP() {
        return fullAFP;
    }

    public void setFullAFP(int fullAFP) {
        this.fullAFP = fullAFP;
    }

    public double getTpi_faktor() {
        return tpi_faktor;
    }

    public void setTpi_faktor(double tpi_faktor) {
        this.tpi_faktor = tpi_faktor;
    }

    public int getUtbetaltAFP() {
        return utbetaltAFP;
    }

    public void setUtbetaltAFP(int utbetaltAFP) {
        this.utbetaltAFP = utbetaltAFP;
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

    @Override
    public int compareTo(AfpUtbetalingsperiode periode) {
        return DateCompareUtil.compareTo(getVirkFom(), periode.getVirkFom());
    }
	
	public void setAfpTpoUpGrunnlag(no.nav.domain.pensjon.regler.grunnlag.AfpTpoUpGrunnlag AfpTpoUpGrunnlag) {
		this.AfpTpoUpGrunnlag = AfpTpoUpGrunnlag;
	}
	
	public no.nav.domain.pensjon.regler.grunnlag.AfpTpoUpGrunnlag getAfpTpoUpGrunnlag() {
		return AfpTpoUpGrunnlag;
	}
	
	public void setAfpTpoUpGrunnlagAnvendt(boolean AfpTpoUpGrunnlagAnvendt) {
		this.AfpTpoUpGrunnlagAnvendt = AfpTpoUpGrunnlagAnvendt;
		
	}
	
	public boolean getAfpTpoUpGrunnlagAnvendt() {
		return AfpTpoUpGrunnlagAnvendt;	
	}

}
