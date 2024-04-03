package no.nav.pensjon.regler.to

import java.util.*

/**
 * Dataoverføringsobjekt, inndata, for tjenesten beregnMinstepensjon.
 */
class BeregnMinstepensjonRequest : ServiceRequest() {
    var virk: Date? = null
}