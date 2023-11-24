package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable

class ForholdstallUtvalg : Serializable {
    var ft = 0.0
    var forholdstallListe: MutableList<Forholdstall> = mutableListOf()

}