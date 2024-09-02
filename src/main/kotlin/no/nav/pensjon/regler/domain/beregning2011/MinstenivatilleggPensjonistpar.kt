package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

/**
 * Endre navn fra "SamletEktefellerGarantitillegg" til "MinstenivatilleggPensjonistpar"
 */
class MinstenivatilleggPensjonistpar : Ytelseskomponent() {
    var bruker: BeregningsInformasjonMinstenivatilleggPensjonistpar? = null
    var ektefelle: BeregningsInformasjonMinstenivatilleggPensjonistpar? = null

    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("MIN_NIVA_TILL_PPAR")
    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.MIN_NIVA_TILL_PPAR

}