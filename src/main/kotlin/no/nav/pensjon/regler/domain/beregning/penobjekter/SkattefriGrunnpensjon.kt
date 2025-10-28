package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum

/**
 * Created by N123422 on 07.11.2014.
 */
class SkattefriGrunnpensjon : BeregningYtelseskomponent() {
    var pensjonsgrad = 0
    override val ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.SKATT_F_GP
}