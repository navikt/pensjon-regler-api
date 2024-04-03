package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.PersonOpptjeningsgrunnlag


class BeregnPoengtallBatchResponse : ServiceResponse() {
    var personOpptjeningsgrunnlagListe: MutableList<PersonOpptjeningsgrunnlag> = mutableListOf()
}