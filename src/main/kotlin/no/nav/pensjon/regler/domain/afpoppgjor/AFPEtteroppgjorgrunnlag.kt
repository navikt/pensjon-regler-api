package no.nav.pensjon.regler.domain.afpoppgjor

import no.nav.pensjon.regler.domain.kode.AfpOrdningTypeCti
import java.io.Serializable
import java.util.*

class AFPEtteroppgjorgrunnlag : Serializable {
    /**
     * Nøkkelfelt brukt av PEN tjenestene.
     * PREG skal ta denne inn og levere den tilbake i alle tjenestene sine.
     */
    var vedtakId: Long = 0

    /**
     * Id til personsobjektet fra PEN
     */
    var penPersonId: Long = 0

    /**
     * Personens Fødselsdato
     */
    var fodselsdato: Date? = null

    /**
     * AFPordningen personen er eller var medlem av
     */
    var afpOrdning: AfpOrdningTypeCti? = null

    /**
     * Skal settes til true når personen har gått over til en annen type pensjon midt i
     * oppgjørsåret
     */
    var overgangTilAnnenPensjon = false

    /**
     * Liste av Utbetalingsperioder.
     */
    var afpUtbetalingsperiodeList: MutableList<AfpUtbetalingsperiode> = mutableListOf()

    /**
     * Brukerregistrert inntekt etter opphør
     */
    var ieo = 0

    /**
     * Brukerregistrert inntekt fær uttak
     */
    var ifu = 0

    /**
     * Pensjonsgivende inntekt i preioden (fra SKD)
     */
    var pgi = 0
    var uttaksdato: Date? = null

    /**
     * Hvis pensjonen opphørte midt i oppgjørsåret skal denne settes til opphørsdato
     */
    var opphorsdato: Date? = null

    /**
     * Beskriver hvilken kategori etteroppgjøret er, samt inntektene som ble beregnet.
     * Skal være null ved kall til KategoriserAFPOppgjor.
     */
    var afpEtteroppgjorKategori: AfpEtteroppgjorKategori? = null
}