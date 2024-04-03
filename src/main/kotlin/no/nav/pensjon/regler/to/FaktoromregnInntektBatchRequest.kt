package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.gomregning.KravFaktoromregningGrunnlag
import java.util.*

class FaktoromregnInntektBatchRequest : ServiceRequest() {
    /**
     * Dato for når gammel regulering gjaldt.
     */
    var gammelReguleringGjaldtDato: Date? = null

    /**
     * Ny dato det skal omregnes for.
     */
    var nyReguleringOmregnFraDato: Date? = null

    /**
     * Liste av grunnlag for faktoromregning.
     */
    var kravFaktoromregningGrunnlagListe = Vector<KravFaktoromregningGrunnlag>()

    /**
     * Angir om tjenestekallet er en batch jobb eller ikke.
     */
    var automaticJob = false
}