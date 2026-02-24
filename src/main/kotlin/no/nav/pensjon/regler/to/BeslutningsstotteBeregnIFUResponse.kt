package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.vedtak.InntektForUforhet

class BeslutningsstotteBeregnIFUResponse : ServiceResponse() {
    var inntektForUforhet: InntektForUforhet? = null
}
