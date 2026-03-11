package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable
import java.util.*
import java.time.LocalDate

class BarnetilleggVurderingsperiode : Serializable {
    @Deprecated("Use fomDatoLd instead")
    var fomDato: Date? = null
    var fomDatoLd: LocalDate? = null
    @Deprecated("Use tomDatoLd instead")
    var tomDato: Date? = null
    var tomDatoLd: LocalDate? = null
    var btVilkarListe: List<BarnetilleggVilkar> = mutableListOf()
}