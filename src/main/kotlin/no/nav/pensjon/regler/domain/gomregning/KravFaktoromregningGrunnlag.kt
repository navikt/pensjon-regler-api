package no.nav.pensjon.regler.domain.gomregning

import java.io.Serializable

class KravFaktoromregningGrunnlag : Serializable {
    var kravId: Long? = null
    var persongrunnlagOmregningGrunnlagListe: MutableList<PersongrunnlagOmregningGrunnlag> = mutableListOf()
}