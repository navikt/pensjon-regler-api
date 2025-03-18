package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.grunnlag.AfpOpptjening

class AfpPrivatBeregning : Beregning2011() {
    @Deprecated("Avvikles. Erstattes av afpPrivatLivsvarigVedUttak.")
    var afpLivsvarig: AfpLivsvarig? = null
    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
    var afpKompensasjonstillegg: AfpKompensasjonstillegg? = null
    var afpKronetillegg: AfpKronetillegg? = null
    var afpOpptjening: AfpOpptjening? = null
}