package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat
import java.util.*

class RegulerBeregningMangelfulltGrunnlagRequest : ServiceRequest() {
    var virkFom: Date? = null
    var beregning1967: Beregning? = null
    var beregningsResultat2011: AbstraktBeregningsResultat? = null
}