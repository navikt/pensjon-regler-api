package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import java.io.Serializable

/**
 * Brukes kun i BEF270 til G-omregning.
 */
class Garantitillegg_Art_50 : Ytelseskomponent(), Serializable {
    init {
        ytelsekomponentType = YtelsekomponentTypeCti("GT_EOS")
    }
}