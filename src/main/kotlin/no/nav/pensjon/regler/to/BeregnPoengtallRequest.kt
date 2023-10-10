package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.Opptjeningsgrunnlag
import java.util.*

class BeregnPoengtallRequest {
    var opptjening: Opptjeningsgrunnlag? = null
    var fodselsdato: Date? = null
}