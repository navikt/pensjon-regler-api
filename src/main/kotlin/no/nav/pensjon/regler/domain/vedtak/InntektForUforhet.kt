package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.enum.MinimumIfuTypeEnum
import no.nav.pensjon.regler.domain.kode.MinimumIfuTypeCti
import java.util.*

/**
 * Angir inntekt før uførhet (IFU) og hvorvidt inntekten er minimumsgrense eller ikke.
 * Inneholder ulike varianter av inntekt før uførhet som resulterer fra ulike måter å beregne denne inntekten,
 * i tillegg til den endelige inntekten som brukes.
 */
class InntektForUforhet : AbstraktBeregningsvilkar() {
    /**
     * Angir om bruker kvalifiserer til Minste-IFU sats som ung ufør, enslig eller gift.
     */
    var minimumIfuType: MinimumIfuTypeCti? = null
    var minimumIfuTypeEnum: MinimumIfuTypeEnum? = null

    /**
     * Den endelige inntekten før uførhet som brukes.
     */
    var inntekt = 0

    /**
     * Angir om minimums IFU er benyttet eller ikke.
     */
    var erMinimumsIfu = false

    /**
     * Dato for den kroneverdi inntekt er oppgitt i.
     */
    var ifuDato: Date? = null

    /**
     * Den inntekt før uførhet som er angitt av saksbehandler. Ikke justert for minimumsIFU.
     */
    var angittInntekt = 0

}