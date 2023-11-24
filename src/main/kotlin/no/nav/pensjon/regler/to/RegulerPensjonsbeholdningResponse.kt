package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.grunnlag.PersonPensjonsbeholdning
import java.io.Serializable

class RegulerPensjonsbeholdningResponse() : Serializable {
    var pakkseddel: Pakkseddel? = null
    var regulertBeregningsgrunnlagForPensjonsbeholdning: MutableList<PersonPensjonsbeholdning> = mutableListOf()
}