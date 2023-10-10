package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import java.io.Serializable

class BarnetilleggFellesbarnUT : AbstraktBarnetilleggUT(), Serializable {
    /**
     * beløp som er fratrukket annen forelders inntekt (inntil 1G)
     */
    var belopFratrukketAnnenForeldersInntekt = 0

    /**
     * Brukers inntekt
     */
    var brukersInntektTilAvkortning = 0

    /**
     * Annen forelders inntekt brukt i behovsprøving
     */
    var inntektAnnenForelder = 0

    /**
     * Annen forelders uføretrygd før justering.
     */
    var annenForelderUforetrygdForJustering = 0

    init {
        formelKode = FormelKodeCti("BTx")
        ytelsekomponentType = YtelsekomponentTypeCti("UT_TFB")
    }
}