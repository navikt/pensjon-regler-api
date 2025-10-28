package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum

class MinstenivatilleggIndividuelt : Ytelseskomponent() {
    var mpn: MinstePensjonsniva? = null
    var garPN: Garantipensjonsniva? = null
    var samletPensjonForMNT = 0.0

    override val ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.MIN_NIVA_TILL_INDV
}