package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning.Beregning

class RegulerBeregningResponse : ServiceResponse() {
    var regulertBeregning1967: Beregning? = null
}