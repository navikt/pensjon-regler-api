package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.grunnlag.Pensjonsbeholdning
import java.io.Serializable

class BeregnOpptjeningResponse() : Serializable {
    var beholdninger: ArrayList<Pensjonsbeholdning> = ArrayList()

    var pakkseddel = Pakkseddel()

}