package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable

class Forstegangstjeneste : Serializable {
    var periodeListe: List<ForstegangstjenestePeriode> = mutableListOf()
}