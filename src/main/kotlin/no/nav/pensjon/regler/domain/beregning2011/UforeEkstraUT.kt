package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.BeregningUforeperiode
import java.io.Serializable

class UforeEkstraUT : Serializable {
    /**
     * Beregnede uføreperioder for uføretrygd.
     * Dette er uføreperioder som beregnes av pensjon-regler, og ligger ved beregningen for en uføretrygd.
     */
    var beregnetUforeperiodeListe: List<BeregningUforeperiode> = mutableListOf()
}