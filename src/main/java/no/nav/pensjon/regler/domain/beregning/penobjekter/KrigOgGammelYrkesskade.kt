package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import java.io.Serializable

/**
 * Brukes i PREG kun ved g-omregning
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

    init {
        ytelsekomponentType = YtelsekomponentTypeCti("KRIG_GY")
    }
}