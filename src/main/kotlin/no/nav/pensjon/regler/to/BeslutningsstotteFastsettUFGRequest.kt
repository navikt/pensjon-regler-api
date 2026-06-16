package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.vedtak.InntektEtterUforhet
import no.nav.pensjon.regler.domain.vedtak.InntektForUforhet
import no.nav.pensjon.regler.domain.vedtak.Uforegrad

class BeslutningsstotteFastsettUFGRequest(
    /**
     * Fra siste beregningsvilkar periode:
     */
    var inntektForUforhet: InntektForUforhet,
    var inntektEtterUforhet: InntektEtterUforhet,
    var inntektEtterUforhetForrige: InntektEtterUforhet?,
    var uforegradForrige: Uforegrad?
) : ServiceRequest()
