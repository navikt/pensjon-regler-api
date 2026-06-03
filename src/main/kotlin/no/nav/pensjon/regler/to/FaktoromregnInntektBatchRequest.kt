package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.gomregning.KravFaktoromregningGrunnlag
import java.util.*
import java.time.LocalDate

class FaktoromregnInntektBatchRequest : ServiceRequest() {
    /**
     * Dato for når gammel regulering gjaldt.
     */
    var gammelReguleringGjaldtDatoLd: LocalDate? = null

    /**
     * Ny dato det skal omregnes for.
     */
    var nyReguleringOmregnFraDatoLd: LocalDate? = null

    /**
     * Liste av grunnlag for faktoromregning.
     */
    var kravFaktoromregningGrunnlagListe = Vector<KravFaktoromregningGrunnlag>()

    /**
     * Angir om tjenestekallet er en batch jobb eller ikke.
     */
    var automaticJob = false
}