package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.Pakkseddel
import java.io.Serializable

class PersonPensjonsbeholdning : Serializable {
    var pensjonsbeholdning: Pensjonsbeholdning? = null
    var pakkseddel: Pakkseddel? = null
    var fodselsnummer: String? = null
}