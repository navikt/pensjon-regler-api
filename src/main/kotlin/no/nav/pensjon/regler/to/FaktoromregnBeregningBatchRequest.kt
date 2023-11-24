package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.gomregning.BeregningerTilFaktoromregningGrunnlag
import java.util.*

class FaktoromregnBeregningBatchRequest {
    var gammelGGjaldtDato: Date? = null
    var nyGOmregnFraDato: Date? = null
    var beregningerTilFaktoromregningGrunnlagListe = mutableListOf<BeregningerTilFaktoromregningGrunnlag>()

}