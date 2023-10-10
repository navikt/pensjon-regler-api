package no.nav.pensjon.regler.domain.afpoppgjor

import no.nav.pensjon.regler.domain.grunnlag.AfpTpoUpGrunnlag
import java.io.Serializable
import java.util.*

class AfpUtbetalingsperiode : Serializable {
    /**
     * Periodens fradato - not null
     */
    var virkFom: Date? = null

    /**
     * Periodens tildato
     */
    var virkTom: Date? = null

    /**
     * Brutto månedlig AFP i perioden
     */
    var fullAFP = 0

    /**
     * Utbetalt månedlig AFP i perioden
     */
    var utbetaltAFP = 0

    /**
     * Forventet inntekt i perioden
     * (årlig FPI / 12 * antall måneder i perioden)
     */
    var fpi = 0

    /**
     * Tidligere pensjonsgivende inntekts faktor
     */
    var tpi_faktor = 0.0

    /**
     * Graden av utbetalt pensjon i forhold til brtto pensjon
     */
    var afpPensjonsgrad = 0

    /**
     * Objekt som inneholder informasjon om TP-ordningers uførepensjonsgrunnlag. Dette er manuelt registrerte data og ikke hentet fra TP-registeret eller andre eksterne kilder.
     */
    var afpTpoUpGrunnlag: AfpTpoUpGrunnlag? = null

    /**
     * Flagg som sier om UP-grunnlaget fra TPO er benyttet i beregning. Brukes for å bestemme om UP-grunnlaget skal benyttes i etteroppgjørsberegningen.
     */
    var afpTpoUpGrunnlagAnvendt = false
}