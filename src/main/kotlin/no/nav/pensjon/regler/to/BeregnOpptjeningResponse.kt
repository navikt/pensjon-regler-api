package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.grunnlag.Pensjonsbeholdning


class BeregnOpptjeningResponse : ServiceResponse() {
    var beholdninger: ArrayList<Pensjonsbeholdning> = ArrayList()
}