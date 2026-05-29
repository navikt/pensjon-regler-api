package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.vedtak.InntektEtterUforhet
import no.nav.pensjon.regler.domain.vedtak.InntektForUforhet

class BeslutningsstotteBeregnIEUForJan2026Response(
    val ieuBeregnet: Boolean,
    val ieuOppjustertTilVirk: Boolean,
    val inntektEtterUførhet: InntektEtterUforhet,
    val inntektFørUførhet: InntektForUforhet,
) : ServiceResponse()