package no.nav.pensjon.regler.domain.afpoppgjor

import no.nav.pensjon.regler.domain.enum.AFPtypeEnum
import java.io.Serializable
import java.util.*
import java.time.LocalDate

class AFPEtteroppgjorgrunnlag(
    /**
     * Personens Fødselsdato
     */
    @Deprecated("Use fodselsdatoLd instead")
    var fodselsdato: Date? = null,
    var fodselsdatoLd: LocalDate? = null,

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
    @Deprecated("Use uttaksdatoLd instead")
    var uttaksdato: Date? = null,
    var uttaksdatoLd: LocalDate? = null,

    /**
     * Hvis pensjonen opphørte midt i oppgjørsåret skal denne settes til opphørsdato
     */
    @Deprecated("Use opphorsdatoLd instead")
    var opphorsdato: Date? = null,
    var opphorsdatoLd: LocalDate? = null,

    /**
     * Beskriver hvilken kategori etteroppgjøret er, samt inntektene som ble beregnet.
     * Skal være null ved kall til KategoriserAFPOppgjor.
     */
    var afpEtteroppgjorKategori: AfpEtteroppgjorKategori? = null
) : Serializable