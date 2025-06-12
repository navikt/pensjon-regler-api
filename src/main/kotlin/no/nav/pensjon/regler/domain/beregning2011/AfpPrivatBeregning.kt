package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.grunnlag.AfpOpptjening

class AfpPrivatBeregning : Beregning2011() {
    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
    var afpKompensasjonstillegg: AfpKompensasjonstillegg? = null
    var afpKronetillegg: AfpKronetillegg? = null
    var afpOpptjening: AfpOpptjening? = null
}