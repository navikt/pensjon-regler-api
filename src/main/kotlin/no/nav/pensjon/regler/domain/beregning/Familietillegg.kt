package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum

class Familietillegg : Ytelseskomponent() {
    override val ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.FAM_T
}