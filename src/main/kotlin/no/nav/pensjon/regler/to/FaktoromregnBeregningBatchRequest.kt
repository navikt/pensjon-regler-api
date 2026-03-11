package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.gomregning.BeregningerTilFaktoromregningGrunnlag
import java.util.*
import java.time.LocalDate

class FaktoromregnBeregningBatchRequest : ServiceRequest() {
    @Deprecated("Use gammelGGjaldtDatoLd instead")
    var gammelGGjaldtDato: Date? = null
    var gammelGGjaldtDatoLd: LocalDate? = null
    @Deprecated("Use nyGOmregnFraDatoLd instead")
    var nyGOmregnFraDato: Date? = null
    var nyGOmregnFraDatoLd: LocalDate? = null
    var beregningerTilFaktoromregningGrunnlagListe = Vector<BeregningerTilFaktoromregningGrunnlag>()

}