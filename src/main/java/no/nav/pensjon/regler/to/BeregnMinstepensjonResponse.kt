package no.nav.pensjon.regler.to

import java.io.Serializable

/**
 * Dataoverføringsobjekt, returdata, for tjenesten beregnMinstepensjon.
 *
 */
class BeregnMinstepensjonResponse : Serializable {
    var belop: Long = 0
}