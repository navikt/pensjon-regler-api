package no.nav.pensjon.regler.domain.vedtak

import java.util.*

/**
 * Angir inntekt etter uførhet (IEU).
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