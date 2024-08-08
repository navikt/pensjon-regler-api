package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import java.io.Serializable

/**
 * Brukes kun i BEF270 til G-omregning.
 */
class Hjelpeloshetsbidrag : Ytelseskomponent(), Serializable {
    var grunnlagForUtbetaling = 0

    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("HJELP_BIDRAG")
    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.HJELP_BIDRAG

}