package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

class AfpKompensasjonstillegg : Ytelseskomponent() {
    var referansebelop = 0
    var reduksjonsbelop = 0
    var forholdstallKompensasjonstillegg = 0.0

    init {
        ytelsekomponentType = YtelsekomponentTypeCti("AFP_KOMP_TILLEGG")
    }

}