package no.nav.pensjon.regler.domain.vedtak

import java.util.*
import java.time.LocalDate

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
    @Deprecated("Use ieuDatoLd instead")
    var ieuDato: Date? = null
    var ieuDatoLd: LocalDate? = null

}