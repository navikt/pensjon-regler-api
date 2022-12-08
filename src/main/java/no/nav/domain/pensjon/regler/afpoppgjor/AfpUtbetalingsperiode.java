package no.nav.domain.pensjon.regler.afpoppgjor;

import no.nav.domain.pensjon.regler.grunnlag.AfpTpoUpGrunnlag;

import java.io.Serializable;
import java.util.Date;

public class AfpUtbetalingsperiode implements Serializable {


    /**
     * Periodens fradato - not null
     */
    private Date virkFom;
    /**
     * Periodens tildato
     */
    private Date virkTom;
    /**
     * Brutto m�nedlig AFP i perioden
     */
    private int fullAFP;
    /**
     * Utbetalt m�nedlig AFP i perioden
     */
    private int utbetaltAFP;
    /**
     * Forventet inntekt i perioden
     * (�rlig FPI / 12 * antall m�neder i perioden)
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
	* Objekt som inneholder informasjon om TP-ordningers uf�repensjonsgrunnlag. Dette er manuelt registrerte data og ikke hentet fra TP-registeret eller andre eksterne kilder.
	*/
	private no.nav.domain.pensjon.regler.grunnlag.AfpTpoUpGrunnlag AfpTpoUpGrunnlag;
	
	/**
	* Flagg som sier om UP-grunnlaget fra TPO er benyttet i beregning. Brukes for � bestemme om UP-grunnlaget skal benyttes i etteroppgj�rsberegningen.
	*/
	private boolean AfpTpoUpGrunnlagAnvendt;

}
