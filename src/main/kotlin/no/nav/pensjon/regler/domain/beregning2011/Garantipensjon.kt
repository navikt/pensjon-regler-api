package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

class Garantipensjon : Ytelseskomponent() {
    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("GAP")
    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.GAP
}