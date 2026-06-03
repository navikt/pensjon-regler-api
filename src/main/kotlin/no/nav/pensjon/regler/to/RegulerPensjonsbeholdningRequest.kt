package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.PersonPensjonsbeholdning
import java.util.*
import java.time.LocalDate

class RegulerPensjonsbeholdningRequest : ServiceRequest() {
    var virkFomLd: LocalDate? = null
    var beregningsgrunnlagForPensjonsbeholdning: ArrayList<PersonPensjonsbeholdning> = ArrayList()
}