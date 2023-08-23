package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import java.io.Serializable

/**
 * Brukes kun i BEF270 til G-omregning.
 */
open class Garantitillegg_Art_27 : Ytelseskomponent(), Serializable {
    protected var beregning: Beregning? = null

    init {
        ytelsekomponentType = YtelsekomponentTypeCti("GT_NORDISK")
    }
}