package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.vedtak.InntektEtterUforhet
import no.nav.pensjon.regler.domain.vedtak.InntektForUforhet
import no.nav.pensjon.regler.domain.vedtak.Uforegrad
import java.time.LocalDate

class BeslutningsstotteBeregnIEUForJan2026Request(
    val IFUvedVirk: InntektForUforhet,
    val virk: LocalDate,
    val tidligereUføregrad: Uforegrad,
    val tidligereFastsattIEU: InntektEtterUforhet
) : ServiceRequest()