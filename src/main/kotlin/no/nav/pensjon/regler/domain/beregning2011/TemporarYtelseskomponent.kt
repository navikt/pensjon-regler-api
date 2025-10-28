package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum

class TemporarYtelseskomponent : Ytelseskomponent() {
    override val ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.TEMP
}