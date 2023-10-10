package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Grunnpensjon
import no.nav.pensjon.regler.domain.beregning.Sertillegg
import no.nav.pensjon.regler.domain.beregning.Tilleggspensjon
import java.io.Serializable

class Konverteringsgrunnlag : Serializable {
    /**
     * Grunnpensjon for dette konverteringsgrunnlaget
     */
    var gp: Grunnpensjon? = null
    /**
     * Tilleggspensjon for dette konverteringsgrunnlaget
     */
    var tp: Tilleggspensjon? = null
    /**
     * Særtillegg for dette konverteringsgrunnlaget
     * Betinget, hvis uførepensjon er beregnet med særtillegg
     */
    var st: Sertillegg? = null
}