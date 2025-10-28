package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import java.io.Serializable

/**
 * Brukes i pensjon-regler kun ved g-omregning
 */
class KrigOgGammelYrkesskade : Ytelseskomponent(), Serializable {
    /**
     * Pensjonsgraden
     */
    var pensjonsgrad = 0

    /**
     * grunnlag for utbetaling;
     */
    var grunnlagForUtbetaling = 0

    /**
     * Kapital utløsning
     */
    var kapitalutlosning = 0

    /**
     * poengtall
     */
    var ps = 0.0

    /**
     * forholdstall yg
     */
    var yg = 0.0

    /**
     * Men del
     */
    var mendel = 0

    override val ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.KRIG_GY
}