package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.beregning2011.AbstraktBarnetillegg
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import java.io.Serializable

class BarnetilleggFellesbarn : AbstraktBarnetillegg(), Serializable {
    init {
        formelKode = FormelKodeCti("BTx")
        ytelsekomponentType = YtelsekomponentTypeCti("TFB")
    }
}