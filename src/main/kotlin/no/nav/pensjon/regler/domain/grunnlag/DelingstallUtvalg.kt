package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable

class DelingstallUtvalg : Serializable {
    var dt = 0.0
    var delingstallListe: List<Delingstall> = mutableListOf()
}