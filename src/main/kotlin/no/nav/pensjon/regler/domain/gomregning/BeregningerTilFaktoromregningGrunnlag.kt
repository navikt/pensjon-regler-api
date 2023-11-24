package no.nav.pensjon.regler.domain.gomregning

import no.nav.pensjon.regler.domain.beregning.Beregning
import java.io.Serializable

class BeregningerTilFaktoromregningGrunnlag : Serializable {
    var vedtakId: Long? = null
    var beregningGrunnlagListe: MutableList<Beregning> = mutableListOf()
}