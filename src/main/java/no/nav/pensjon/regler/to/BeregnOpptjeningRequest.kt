package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.Pensjonsbeholdning
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag
import java.util.*

/**
 * Dataoverføringsobjekt for tjenesten beregnOpptjening.
 */
class BeregnOpptjeningRequest {
    var beholdningTom: Date? = null
    var persongrunnlag: Persongrunnlag? = null
    var beholdning: Pensjonsbeholdning? = null
}