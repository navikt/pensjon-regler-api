package no.nav.pensjon.regler.to

import java.util.*
import java.time.LocalDate

/**
 * Dataoverføringsobjekt, inndata, for tjenesten beregnMinstepensjon.
 */
class BeregnMinstepensjonRequest : ServiceRequest() {
    @Deprecated("Use virkLd instead")
    var virk: Date? = null
    var virkLd: LocalDate? = null
}