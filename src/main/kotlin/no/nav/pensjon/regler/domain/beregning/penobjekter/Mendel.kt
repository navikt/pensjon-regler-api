package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import java.io.Serializable

/**
 * Brukes kun til G-omregning i BEF270.
 */
class Mendel : Ytelseskomponent(), Serializable {
    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("MENDEL")
    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.MENDEL
}