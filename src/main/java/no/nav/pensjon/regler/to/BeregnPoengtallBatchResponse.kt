package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.PersonOpptjeningsgrunnlag
import java.io.Serializable
import java.util.*

class BeregnPoengtallBatchResponse : Serializable {
    var personOpptjeningsgrunnlagListe = Vector<PersonOpptjeningsgrunnlag>()
}