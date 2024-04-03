package no.nav.pensjon.regler.to


/**
 * Dataoverføringsobjekt, returdata, for tjenesten beregnMinstepensjon.
 *
 */
class BeregnMinstepensjonResponse : ServiceResponse() {
    var belop: Long = 0
}