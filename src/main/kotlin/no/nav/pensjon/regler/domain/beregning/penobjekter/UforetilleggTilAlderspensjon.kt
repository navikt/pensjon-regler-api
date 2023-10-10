package no.nav.pensjon.regler.domain.beregning.penobjekter

import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

/**
 * Created by N123422 on 07.11.2014.
 */
class UforetilleggTilAlderspensjon : Ytelseskomponent() {
    var beregning: Beregning? = null

    init {
        ytelsekomponentType = YtelsekomponentTypeCti("UFORETILLEGG_AP")
    }
}