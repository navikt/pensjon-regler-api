package no.nav.pensjon.regler.domain.afpoppgjor

import no.nav.pensjon.regler.domain.BatchStatus
import java.io.Serializable
import java.util.*

class AFPetteroppgjor(
    /**
     * Datoen for uttak av AFP - hvis dette skjedde i oppgjørsperioden
     */
    var uttaksdato: Date? = null,

    /**
     * Datoen for opphår av AFP - hvis dette skjedde i oppgjørsperioden
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
     * Status fra pensjon-regler per element
     */
    var status: BatchStatus? = null
) : Serializable