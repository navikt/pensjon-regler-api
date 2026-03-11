package no.nav.pensjon.regler.domain.vedtak

import java.util.*
import java.time.LocalDate

class Skadetidspunkt : AbstraktBeregningsvilkar() {
    @Deprecated("Use datoLd instead")
    var dato: Date? = null
    var datoLd: LocalDate? = null

}