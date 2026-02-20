package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.InntektKontrollGrunnlag

class BeslutningsstotteBeregnFORINTRequest(
    /** Grunnlag for inntektskontroll. Påkrevd. */
    var inntektKontrollGrunnlag: InntektKontrollGrunnlag
) : ServiceRequest()
