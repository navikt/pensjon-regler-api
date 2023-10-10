package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

open class AfpLivsvarig : Ytelseskomponent() {
    var justeringsbelop = 0
    var afpProsentgrad = 0.0
    var afpForholdstall = 0.0

    init {
        formelKode = FormelKodeCti("AFPx")
        ytelsekomponentType = YtelsekomponentTypeCti("AFP_LIVSVARIG")
    }

}