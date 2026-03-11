package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.Pensjonsbeholdning
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag
import java.util.Date
import java.time.LocalDate

class BeregnPensjonsBeholdningRequest : ServiceRequest() {
    @Deprecated("Use beholdningTomLd instead")
    var beholdningTom: Date? = null
    var beholdningTomLd: LocalDate? = null
    var persongrunnlag: Persongrunnlag? = null
    var beholdning: Pensjonsbeholdning? = null
}