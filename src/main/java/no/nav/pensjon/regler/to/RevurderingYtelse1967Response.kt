package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning.Beregning
import java.io.Serializable

class RevurderingYtelse1967Response : Serializable {
    var beregning1967: Beregning? = null
    var beregning1967TilRevurdering: Beregning? = null
    var pakkseddel: Pakkseddel? = null
}