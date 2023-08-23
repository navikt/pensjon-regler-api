package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import java.io.Serializable

/**
 * @author Ingleiv Johansen (Accenture) - PK-7250
 * @author Lars Hartvigsen (Decisive) - PK-20946
 */
class BarnetilleggSerkullsbarnUT : AbstraktBarnetilleggUT(), Serializable {
    /**
     * Brukers gjenlevendetillegg før justering.
     */
    var brukersGjenlevendetilleggForJustering = 0

    init {
        ytelsekomponentType = YtelsekomponentTypeCti("UT_TSB")
        formelKode = FormelKodeCti("BTx")
    }
}