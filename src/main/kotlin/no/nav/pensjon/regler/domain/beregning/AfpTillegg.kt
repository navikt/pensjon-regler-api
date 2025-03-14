package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum

class AfpTillegg : Ytelseskomponent() {
    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.AFP_T
}