package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import java.io.Serializable

/**
 * Brukes kun i BEF270 til G-omregning.
 */
open class Garantitillegg_Art_27 : Ytelseskomponent(), Serializable {
    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.GT_NORDISK
}