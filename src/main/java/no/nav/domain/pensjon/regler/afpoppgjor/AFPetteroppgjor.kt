package no.nav.domain.pensjon.regler.afpoppgjor

import no.nav.domain.pensjon.regler.BatchStatus
import java.io.Serializable
import java.util.*

class AFPetteroppgjor(
    /**
     * Nøkkelfelt brukt av PEN tjenestene.
     * PREG skal ta denne inn og levere den tilbake i alle tjenestene sine.
     */
    var vedtakId: Long = 0,

    /**
     * Id til personsobjektet fra PEN
     */
    var penPersonId: Long = 0,

    /**
     * Datoen for uttak av AFP - hvis dette skjedde i oppgjørsperioden
     */
    var uttaksdato: Date? = null,

    /**
     * Datoen for opphør av AFP - hvis dette skjedde i oppgjørsperioden
     */
    var opphorsdato: Date? = null,

    /**
     * Full AFP pensjon i perioden
     */
    var fullAFP: Int = 0,

    /**
     * Utbetalt AFP i perioden
     */
    var utbetaltAFP: Int = 0,

    /**
     * Korrigert AFP for perioden
     */
    var korrigertAFP: Int = 0,

    /**
     * Beløpet som skal tilbakekreves - hvis det er utbetalt for mye
     */
    var forMyeUtbetalt: Int = 0,

    /**
     * Beløpet som skal utbetales - hvis det er utbetalt for lite
     */
    var forLiteUtbetalt: Int = 0,

    /**
     * Mellomberegning: IIAP/beregnetTPI*fullAFP
     */
    var fradragBeregnetArbeidsinntekt: Int = 0,

    /**
     * Beregnet TPI i AFP-perioden
     */
    var beregnetTPI: Int = 0,

    /**
     * Status fra PREG per element
     */
    var status: BatchStatus? = null
) : Serializable
