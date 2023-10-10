package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

/**
 * Created by N123422 on 07.11.2014.
 */
class SykepengerUT : MotregningYtelseskomponent() {
    init {
        ytelsekomponentType = YtelsekomponentTypeCti("UT_SP")
    }
}