package no.nav.pensjon.regler.domain.beregning2011

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import no.nav.pensjon.regler.domain.vedtak.VilkarsprovInformasjon2011
import no.nav.pensjon.regler.domain.vedtak.VilkarsprovInformasjon2016
import no.nav.pensjon.regler.domain.vedtak.VilkarsprovInformasjon2025

@JsonSubTypes(
    JsonSubTypes.Type(value = FremskrevetAfpLivsvarig::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
open class AfpLivsvarig : Ytelseskomponent {
    var justeringsbelop = 0
    var afpProsentgrad = 0.0
    var afpForholdstall = 0.0

    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("AFP_LIVSVARIG")

    constructor() {
        formelKode = FormelKodeCti("AFPx")
    }

    constructor(o: AfpLivsvarig) : super(o) {
        afpForholdstall = o.afpForholdstall
        afpProsentgrad = o.afpProsentgrad
        justeringsbelop = o.justeringsbelop
    }
}