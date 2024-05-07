package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

/**
 * Created by N123422 on 07.11.2014.
 */
class SkattefriGrunnpensjon : BeregningYtelseskomponent() {
    var pensjonsgrad = 0
    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("SKATT_F_GP")
}