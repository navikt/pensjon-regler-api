package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.grunnlag.Pensjonsbeholdning

@Deprecated("Avvikles. Bruk BeregnPensjonsBeholdningResponse.", ReplaceWith("no.nav.pensjon.regler.to.BeregnPensjonsBeholdningResponse"))
class BeregnOpptjeningResponse : ServiceResponse() {
    var beholdninger: ArrayList<Pensjonsbeholdning> = ArrayList()
}