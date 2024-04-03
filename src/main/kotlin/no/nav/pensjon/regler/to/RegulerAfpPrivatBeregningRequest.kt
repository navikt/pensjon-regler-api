package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAfpPrivat
import java.util.*

class RegulerAfpPrivatBeregningRequest : ServiceRequest() {
    var virkFom: Date? = null
    var virkFomAfpFrivatUttak: Date? = null
    var beregningsResultat: BeregningsResultatAfpPrivat? = null
}