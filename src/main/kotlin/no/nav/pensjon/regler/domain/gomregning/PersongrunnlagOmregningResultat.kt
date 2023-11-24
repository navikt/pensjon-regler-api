package no.nav.pensjon.regler.domain.gomregning

import no.nav.pensjon.regler.domain.grunnlag.Inntektsgrunnlag
import java.io.Serializable

class PersongrunnlagOmregningResultat : Serializable {
    var persongrunnlagId: Long? = null
    var inntektsgrunnlagResultatListe: MutableList<Inntektsgrunnlag> = mutableListOf()

}