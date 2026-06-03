package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.ForstegangstjenestetypeEnum
import java.io.Serializable
import java.util.*
import java.time.LocalDate

class ForstegangstjenestePeriode : Serializable {
    var fomDatoLd: LocalDate? = null
    var tomDatoLd: LocalDate? = null
    var periodeTypeEnum: ForstegangstjenestetypeEnum? = null
}