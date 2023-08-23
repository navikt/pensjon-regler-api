package no.nav.pensjon.regler.domain.vedtak

import java.util.*

/**
 * Angir inntekt etter uførhet (IEU).
 *
 * @author Magnus Bakken (Accenture), PK-9491, PK-10597 PKPYTON-1063
 * @author Steinar Hjellvik (Decisive), PK-6172
 */
class InntektEtterUforhet : AbstraktBeregningsvilkar() {
    /**
     * Inntekten.
     */
    var inntekt = 0

    /**
     * Virkningstidspunktet for inntekt etter uførhet.
     */
    var ieuDato: Date? = null

}