package no.nav.domain.pensjon.regler.afpoppgjor

import no.nav.domain.pensjon.regler.kode.AfpOrdningTypeCti
import java.io.Serializable
import java.util.*

class AFPEtteroppgjorgrunnlag(
    /**
     * N�kkelfelt brukt av PEN tjenestene.
     * PREG skal ta denne inn og levere den tilbake i alle tjenestene sine.
     */
    var vedtakId: Long = 0,

    /**
     * Id til personsobjektet fra PEN
     */
    var penPersonId: Long = 0,

    /**
     * Personens f�dselsdato
     */
    var fodselsdato: Date? = null,

    /**
     * AFPordningen personen er eller var medlem av
     */
    var afpOrdning: AfpOrdningTypeCti? = null,

    /**
     * Skal settes til true n�r personen har g�tt over til en annen type pensjon midt i
     * oppgj�rs�ret
     */
    var isOvergangTilAnnenPensjon: Boolean = false,

    /**
     * Liste av Utbetalingsperioder.
     */
    var afpUtbetalingsperiodeList: List<AfpUtbetalingsperiode> = listOf(),

    /**
     * Brukerregistrert inntekt etter opph�r
     */
    var ieo: Int = 0,

    /**
     * Brukerregistrert inntekt f�r uttak
     */
    var ifu: Int = 0,

    /**
     * Pensjonsgivende inntekt i preioden (fra SKD)
     */
    var pgi: Int = 0,
    var uttaksdato: Date? = null,

    /**
     * Hvis pensjonen opph�rte midt i oppgj�rs�ret skal denne settes til opph�rsdato
     */
    var opphorsdato: Date? = null,

    /**
     * Beskriver hvilken kategori etteroppgj�ret er, samt inntektene som ble beregnet.
     * Skal v�re null ved kall til KategoriserAFPOppgjor.
     */
    var afpEtteroppgjorKategori: AfpEtteroppgjorKategori? = null
) : Serializable