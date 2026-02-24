package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.vedtak.InntektForUforhet

class BeslutningsstotteKonverterIFUResponse : ServiceResponse() {
    var inntektForUforhet: InntektForUforhet? = null
}
