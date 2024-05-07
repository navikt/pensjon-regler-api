package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import java.io.Serializable

/**
 * Brukes kun av BEF270 til G-omregning.
 */
class TilleggTilHjelpIHuset : Ytelseskomponent(), Serializable {
    var grunnlagForUtbetaling = 0

    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("HJELP_I_HUS")

}