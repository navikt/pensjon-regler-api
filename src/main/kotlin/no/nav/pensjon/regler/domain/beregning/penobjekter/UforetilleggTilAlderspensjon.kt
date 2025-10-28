package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum

/**
 * Created by N123422 on 07.11.2014.
 */
class UforetilleggTilAlderspensjon : Ytelseskomponent() {
    var beregning: Beregning? = null

    override val ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.UFORETILLEGG_AP

}