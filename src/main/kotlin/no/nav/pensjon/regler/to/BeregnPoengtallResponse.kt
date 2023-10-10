package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.Opptjeningsgrunnlag
import java.io.Serializable
import java.util.*

class BeregnPoengtallResponse : Serializable {
    var opptjening: Opptjeningsgrunnlag? = null
    var fodselsdato: Date? = null
}