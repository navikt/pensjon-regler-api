package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.PersonOpptjeningsgrunnlag


class BeregnPoengtallBatchRequest : ServiceRequest() {
    var personOpptjeningsgrunnlagListe: MutableList<PersonOpptjeningsgrunnlag?> = mutableListOf()
}