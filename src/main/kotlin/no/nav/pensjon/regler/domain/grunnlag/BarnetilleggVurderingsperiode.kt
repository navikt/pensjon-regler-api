package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*
import java.time.LocalDate

class BarnetilleggVurderingsperiode : Serializable {
    var fomDatoLd: LocalDate? = null
    var tomDatoLd: LocalDate? = null
    var btVilkarListe: List<BarnetilleggVilkar> = mutableListOf()
}