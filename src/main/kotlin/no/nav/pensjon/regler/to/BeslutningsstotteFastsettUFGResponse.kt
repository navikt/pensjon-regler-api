package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.vedtak.Uforegrad

class BeslutningsstotteFastsettUFGResponse : ServiceResponse() {
    var uforegrad: Uforegrad? = null
}
