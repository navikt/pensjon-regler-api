package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.grunnlag.PersonPensjonsbeholdning


class RegulerPensjonsbeholdningResponse : ServiceResponse() {
    var regulertBeregningsgrunnlagForPensjonsbeholdning: ArrayList<PersonPensjonsbeholdning> = ArrayList()
}