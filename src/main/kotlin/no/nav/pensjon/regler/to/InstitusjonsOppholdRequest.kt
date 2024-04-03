package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.InstOpphPeriodegrunnlag
import java.util.*

class InstitusjonsOppholdRequest : ServiceRequest() {
    var instOpphPeriodegrunnlagListe: List<InstOpphPeriodegrunnlag> = Vector()
}