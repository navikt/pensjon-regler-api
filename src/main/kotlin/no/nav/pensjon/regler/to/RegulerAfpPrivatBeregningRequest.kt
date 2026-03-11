package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAfpPrivat
import java.util.*
import java.time.LocalDate

class RegulerAfpPrivatBeregningRequest : ServiceRequest() {
    @Deprecated("Use virkFomLd instead")
    var virkFom: Date? = null
    var virkFomLd: LocalDate? = null
    @Deprecated("Use virkFomAfpFrivatUttakLd instead")
    var virkFomAfpFrivatUttak: Date? = null
    var virkFomAfpFrivatUttakLd: LocalDate? = null
    var beregningsResultat: BeregningsResultatAfpPrivat? = null
}