package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import java.time.LocalDate

class AfpOffentligLivsvarig : AfpLivsvarig {
    var sistRegulert: LocalDate? = null

    constructor() : super(
        ytelsekomponentType = YtelsekomponentTypeCti("AFP_OFFENTLIG_LIVSVARIG"),
        formelKode = FormelKodeCti("AFPx")
    )

    constructor(afpOffentligLivsvarig: AfpOffentligLivsvarig) : super(afpOffentligLivsvarig) {
        sistRegulert = afpOffentligLivsvarig.sistRegulert
    }

}