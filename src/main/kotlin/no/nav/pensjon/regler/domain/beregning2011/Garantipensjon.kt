package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum

class Garantipensjon : Ytelseskomponent() {
    override val ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.GAP
}