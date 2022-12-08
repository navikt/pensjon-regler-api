package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.kode.MinimumIfuTypeCti;

import java.util.Date;

/**
 * Angir inntekt før uførhet (IFU) og hvorvidt inntekten er minimumsgrense eller ikke.
 * Inneholder ulike varianter av inntekt før uførhet som resulterer fra ulike måter å beregne denne inntekten,
 * i tillegg til den endelige inntekten som brukes.
 *
 * @author Magnus Bakken (Accenture), PK-9491, PK-6987, PK-10597 PKPYTON-1063
 * @author Lars Hartviksen (Decisive), PK-6180
 * @author Swiddy de Louw (Capgemini), PK-7973 PKPYTON-526
 * @author Frederik Rønenvig (Decisive) - PK-14979
 * @author Aasmund Nordstoga (Accenture) - PK-16378, PKPYTON-1754
 */
public class InntektForUforhet extends AbstraktBeregningsvilkar {
	
	/**
     * Angir om bruker kvalifiserer til Minste-IFU sats som ung ufør, enslig eller gift.
     */
   	private MinimumIfuTypeCti minimumIfuType;

    /**
     * Den endelige inntekten før uførhet som brukes.
     */
    private int inntekt;

    /**
     * Angir om minimums IFU er benyttet eller ikke.
     */
    private boolean erMinimumsIfu;

    /**
     * Dato for den kroneverdi inntekt er oppgitt i.
     */
    private Date ifuDato;

    /**
     * Den inntekt før uførhet som er angitt av saksbehandler. Ikke justert for minimumsIFU.
     */
    private int angittInntekt;
}
