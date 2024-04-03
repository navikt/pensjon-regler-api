package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.krav.Kravhode

class KontrollerInformasjonsgrunnlagRequest : ServiceRequest() {
    var kravhode: Kravhode? = null
}