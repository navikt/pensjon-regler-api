package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*

class BarnetilleggVurderingsperiode : Serializable {
    var fomDato: Date? = null
    var tomDato: Date? = null
    var btVilkarListe: MutableList<BarnetilleggVilkar> = mutableListOf()
}