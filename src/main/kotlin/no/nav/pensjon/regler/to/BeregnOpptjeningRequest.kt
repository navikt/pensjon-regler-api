package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.Pensjonsbeholdning
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag
import java.util.*

/**
 * Dataoverføringsobjekt for tjenesten beregnOpptjening.
 */
@Deprecated("Avvikles. Bruk BeregnPensjonsBeholdningRequest.", ReplaceWith("no.nav.pensjon.regler.to.BeregnPensjonsBeholdningRequest"))
class BeregnOpptjeningRequest : ServiceRequest() {
    var beholdningTom: Date? = null
    var persongrunnlag: Persongrunnlag? = null
    var beholdning: Pensjonsbeholdning? = null
}