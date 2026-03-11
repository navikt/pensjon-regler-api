package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.ForstegangstjenestetypeEnum
import java.io.Serializable
import java.util.*
import java.time.LocalDate

class ForstegangstjenestePeriode : Serializable {
    @Deprecated("Use fomDatoLd instead")
    var fomDato: Date? = null
    var fomDatoLd: LocalDate? = null
    @Deprecated("Use tomDatoLd instead")
    var tomDato: Date? = null
    var tomDatoLd: LocalDate? = null
    var periodeTypeEnum: ForstegangstjenestetypeEnum? = null
}