package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.PersonPensjonsbeholdning
import java.util.*
import java.time.LocalDate

class RegulerPensjonsbeholdningRequest : ServiceRequest() {
    @Deprecated("Use virkFomLd instead")
    var virkFom: Date? = null
    var virkFomLd: LocalDate? = null
    var beregningsgrunnlagForPensjonsbeholdning: ArrayList<PersonPensjonsbeholdning> = ArrayList()
}