package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAfpPrivat
import java.util.*
import java.time.LocalDate

class RegulerAfpPrivatBeregningRequest : ServiceRequest() {
    var virkFomLd: LocalDate? = null
    var virkFomAfpFrivatUttakLd: LocalDate? = null
    var beregningsResultat: BeregningsResultatAfpPrivat? = null
}