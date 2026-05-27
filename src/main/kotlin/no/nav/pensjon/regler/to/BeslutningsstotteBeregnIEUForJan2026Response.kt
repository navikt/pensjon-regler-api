package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.vedtak.InntektEtterUforhet

class BeslutningsstotteBeregnIEUForJan2026Response(
    val ieuOppjustert: Boolean,
    val inntektEtterUforhet: InntektEtterUforhet
) : ServiceResponse()