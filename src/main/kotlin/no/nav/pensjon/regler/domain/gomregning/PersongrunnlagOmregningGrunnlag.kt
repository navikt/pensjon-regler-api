package no.nav.pensjon.regler.domain.gomregning

import no.nav.pensjon.regler.domain.grunnlag.Inntektsgrunnlag
import java.io.Serializable

class PersongrunnlagOmregningGrunnlag : Serializable {
    var persongrunnlagId: Long? = null
    var inntektsgrunnlagGrunnlagListe: MutableList<Inntektsgrunnlag> = mutableListOf()
    var lonnsvekstOmregn = false
}