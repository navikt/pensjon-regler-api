package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning.Beregning
import java.io.Serializable

class RegulerBeregningResponse : Serializable {
    var regulertBeregning1967: Beregning? = null
    var pakkseddel: Pakkseddel? = null
}