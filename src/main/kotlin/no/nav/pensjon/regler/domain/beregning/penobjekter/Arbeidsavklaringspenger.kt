package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

/**
 * Created by N123422 on 06.11.2014.
 */
class Arbeidsavklaringspenger : MotregningYtelseskomponent() {
    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("AAP")
    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.AAP
}