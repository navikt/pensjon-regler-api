package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.PersonPensjonsbeholdning
import java.util.*

class RegulerPensjonsbeholdningRequest : ServiceRequest() {
    var virkFom: Date? = null
    var beregningsgrunnlagForPensjonsbeholdning: ArrayList<PersonPensjonsbeholdning> = ArrayList()
}