package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum

class AfpKompensasjonstillegg : Ytelseskomponent() {
    var referansebelop = 0
    var reduksjonsbelop = 0
    var forholdstallKompensasjonstillegg = 0.0

    override val ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.AFP_KOMP_TILLEGG
}