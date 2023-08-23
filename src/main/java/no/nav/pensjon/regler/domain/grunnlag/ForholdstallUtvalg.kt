package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable

class ForholdstallUtvalg : Serializable {
    var ft = 0.0
    var pREG_ft67soker = 0.0
    var pREG_ft67virk = 0.0
    var pREG_reguleringsfaktor = 0.0
    var forholdstallListe: List<Forholdstall> = mutableListOf()

}