package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.PersonOpptjeningsgrunnlag
import java.util.*

class BeregnPoengtallBatchRequest {
    var personOpptjeningsgrunnlagliste = Vector<PersonOpptjeningsgrunnlag>()

    constructor() : super()
    constructor(personOpptjeningsgrunnlagListe: Vector<PersonOpptjeningsgrunnlag>) : super() {
        personOpptjeningsgrunnlagliste = personOpptjeningsgrunnlagListe
    }
}