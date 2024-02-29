package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

class AfpPrivatLivsvarig : AfpLivsvarig {
    var justeringsbelop: Int = 0
    var afpProsentgrad: Double = 0.0
    var afpForholdstall: Double = 0.0


    constructor() : super(
        ytelsekomponentType = YtelsekomponentTypeCti("AFP_PRIVAT_LIVSVARIG"),
        formelKode = FormelKodeCti("AFPx")
    )

    constructor(o: AfpPrivatLivsvarig) : super(o) {
        afpForholdstall = o.afpForholdstall
        afpProsentgrad = o.afpProsentgrad
        justeringsbelop = o.justeringsbelop
    }
}