package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat
import java.io.Serializable
import java.util.*

class RegulerBeregningMangelfulltGrunnlagResponse() : Serializable {
    var pakkseddel: Pakkseddel? = null
    var beregning1967: Beregning? = null
    var beregningsResultat2011: AbstraktBeregningsResultat? = null

    constructor(
        virkFom: Date?,
        beregning1967: Beregning?,
        beregningsResultat2011: AbstraktBeregningsResultat?
    ) : this() {
        this.beregning1967 = beregning1967
        this.beregningsResultat2011 = beregningsResultat2011
    }

    companion object {
        private const val serialVersionUID = 1245764083517519824L
    }
}