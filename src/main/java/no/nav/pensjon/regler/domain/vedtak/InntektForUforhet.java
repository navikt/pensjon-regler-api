package no.nav.pensjon.regler.domain.vedtak;

import no.nav.pensjon.regler.domain.kode.MinimumIfuTypeCti;

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

    private static final long serialVersionUID = -3693980369960654018L;
	
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

    public InntektForUforhet() {
        super();
    }

    public InntektForUforhet(InntektForUforhet inntektForUforhet) {
        super(inntektForUforhet);
        inntekt = inntektForUforhet.inntekt;
        erMinimumsIfu = inntektForUforhet.erMinimumsIfu;
        angittInntekt = inntektForUforhet.angittInntekt;
        if (inntektForUforhet.minimumIfuType != null) {
            minimumIfuType = new MinimumIfuTypeCti(inntektForUforhet.minimumIfuType);
        }
        if (inntektForUforhet.ifuDato != null) {
            ifuDato = (Date) inntektForUforhet.ifuDato.clone();
        }
    }

    public int getInntekt() {
        return inntekt;
    }

    public void setInntekt(int inntekt) {
        this.inntekt = inntekt;
    }

    public boolean getErMinimumsIfu() {
        return erMinimumsIfu;
    }

    public void setErMinimumsIfu(boolean erMinimumsIfu) {
        this.erMinimumsIfu = erMinimumsIfu;
    }

    public Date getIfuDato() {
        return ifuDato;
    }

    public void setIfuDato(Date ifuDato) {
        this.ifuDato = ifuDato;
    }

	 /**
     * @param minimumIfuType the minimumIfuType to set
     */
   	public void setMinimumIfuType(MinimumIfuTypeCti minimumIfuType) {
		this.minimumIfuType = minimumIfuType;
	}
	
	/**
     * @return minimumIfuType som angir om bruker kvalifiserer til Minste-IFU sats som ung ufør, enslig eller gift
     */
   	public MinimumIfuTypeCti getMinimumIfuType() {
		return minimumIfuType;
	}

    public AbstraktBeregningsvilkar dypKopi(AbstraktBeregningsvilkar abs) {
        InntektForUforhet ifu = null;
        if(abs.getClass() == InntektForUforhet.class) {
            ifu = new InntektForUforhet((InntektForUforhet) abs);
        }
        return ifu;
    }

    public int getAngittInntekt() {
        return angittInntekt;
    }

    public void setAngittInntekt(int angittInntekt) {
        this.angittInntekt = angittInntekt;
    }
}
