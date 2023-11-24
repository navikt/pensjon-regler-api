package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable

class Beholdninger : Serializable {
    var beholdninger: MutableList<Beholdning> = mutableListOf()
}