package no.nav.pensjon.regler.domain.afpoppgjor

import no.nav.pensjon.regler.domain.enum.AFPtypeEnum
import java.io.Serializable
import java.util.*

class AFPEtteroppgjorgrunnlag(
    /**
     * Nøkkelfelt brukt av PEN tjenestene.
     * pensjon-regler skal ta denne inn og levere den tilbake i alle tjenestene sine.
     */
    @Deprecated("Avvikles.")
    var vedtakId: Long = 0,

    /**
     * Id til personsobjektet fra PEN
     */
    @Deprecated("Avvikles.")
    var penPersonId: Long = 0,

    /**
     * Personens Fødselsdato
     */
    var fodselsdato: Date? = null,

    /**
     * AFPordningen personen er eller var medlem av
     */
    var afpOrdningEnum: AFPtypeEnum? = null,

    /**
     * Skal settes til true når personen har gått over til en annen type pensjon midt i
     * oppgjørsåret
     */
    var overgangTilAnnenPensjon: Boolean = false,

    /**
     * Liste av Utbetalingsperioder.
     */
    var afpUtbetalingsperiodeList: List<AfpUtbetalingsperiode> = mutableListOf(),

    /**
     * Brukerregistrert inntekt etter opphør
     */
    var ieo: Int = 0,

    /**
     * Brukerregistrert inntekt fær uttak
     */
    var ifu: Int = 0,

    /**
     * Pensjonsgivende inntekt i preioden (fra SKD)
     */
    var pgi: Int = 0,
    var uttaksdato: Date? = null,

    /**
     * Hvis pensjonen opphørte midt i oppgjørsåret skal denne settes til opphørsdato
     */
    var opphorsdato: Date? = null,

    /**
     * Beskriver hvilken kategori etteroppgjøret er, samt inntektene som ble beregnet.
     * Skal være null ved kall til KategoriserAFPOppgjor.
     */
    var afpEtteroppgjorKategori: AfpEtteroppgjorKategori? = null
) : Serializable