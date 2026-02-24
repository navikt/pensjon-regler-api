package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.InntektsberegningsResultat

class BeslutningsstotteBeregnFORINTResponse : ServiceResponse() {
    var inntektsberegningsResultat: InntektsberegningsResultat? = null
}
