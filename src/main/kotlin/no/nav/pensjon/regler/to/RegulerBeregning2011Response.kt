package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat
import java.io.Serializable

class RegulerBeregning2011Response : Serializable {
    var beregningsResultat: AbstraktBeregningsResultat? = null
    var pakkseddel: Pakkseddel? = null
}