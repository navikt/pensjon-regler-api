package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

/**
 * Created by N123422 on 07.11.2014.
 */
class Garantitillegg_Art_27_UT : Ytelseskomponent() {
    init {
        ytelsekomponentType = YtelsekomponentTypeCti("UT_GT_NORDISK")
    }
}