package no.nav.domain.pensjon.regler.vedtak;

import java.util.Date;

/**
 * Angir inntekt etter uførhet (IEU).
 *
 * @author Magnus Bakken (Accenture), PK-9491, PK-10597 PKPYTON-1063
 * @author Steinar Hjellvik (Decisive), PK-6172
 */
public class InntektEtterUforhet extends AbstraktBeregningsvilkar {

    /**
     * Inntekten.
     */
    private int inntekt;

    /**
     * Virkningstidspunktet for inntekt etter uførhet.
     */
    private Date ieuDato;

}
