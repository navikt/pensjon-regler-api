package no.nav.pensjon.regler.domain.afpoppgjor

import no.nav.pensjon.regler.domain.BatchStatus
import java.io.Serializable
import java.util.*

class AFPetteroppgjor : Serializable {
    /**
     * Nøkkelfelt brukt av PEN tjenestene.
     * pensjon-regler skal ta denne inn og levere den tilbake i alle tjenestene sine.
     */
    var vedtakId: Long = 0

    /**
     * Id til personsobjektet fra PEN
     */
    var penPersonId: Long = 0

    /**
     * Datoen for uttak av AFP - hvis dette skjedde i oppgjørsperioden
     */
    var uttaksdato: Date? = null

    /**
     * Datoen for opphår av AFP - hvis dette skjedde i oppgjørsperioden
     */
    var opphorsdato: Date? = null

    /**
     * Full AFP pensjon i perioden
     */
    var fullAFP = 0

    /**
     * Utbetalt AFP i perioden
     */
    var utbetaltAFP = 0

    /**
     * Korrigert AFP for perioden
     */
    var korrigertAFP = 0

    /**
     * Beløpet som skal tilbakekreves - hvis det er utbetalt for mye
     */
    var forMyeUtbetalt = 0

    /**
     * Beløpet som skal utbetales - hvis det er utbetalt for lite
     */
    var forLiteUtbetalt = 0

    /**
     * Mellomberegning: IIAP/beregnetTPI*fullAFP
     */
    var fradragBeregnetArbeidsinntekt = 0

    /**
     * Beregnet TPI i AFP-perioden
     */
    var beregnetTPI = 0

    /**
     * Status fra pensjon-regler per element
     */
    var status: BatchStatus? = null
}