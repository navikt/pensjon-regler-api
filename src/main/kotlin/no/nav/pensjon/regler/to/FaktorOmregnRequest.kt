package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat
import java.util.Date
import java.time.LocalDate

class FaktorOmregnRequest : ServiceRequest() {
    @Deprecated("Use virkFomLd instead")
    var virkFom: Date? = null
    var virkFomLd: LocalDate? = null
    var beregning1967: Beregning? = null
    var beregningsResultat2011: AbstraktBeregningsResultat? = null
}