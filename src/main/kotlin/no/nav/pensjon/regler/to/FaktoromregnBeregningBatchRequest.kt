package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.gomregning.BeregningerTilFaktoromregningGrunnlag
import java.util.*
import java.time.LocalDate

class FaktoromregnBeregningBatchRequest : ServiceRequest() {
    var gammelGGjaldtDatoLd: LocalDate? = null
    var nyGOmregnFraDatoLd: LocalDate? = null
    var beregningerTilFaktoromregningGrunnlagListe = Vector<BeregningerTilFaktoromregningGrunnlag>()

}