package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.ForstegangstjenestetypeEnum
import java.io.Serializable
import java.util.*

class ForstegangstjenestePeriode : Serializable {
    var fomDato: Date? = null
    var tomDato: Date? = null
    var periodeTypeEnum: ForstegangstjenestetypeEnum? = null
}