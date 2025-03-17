package no.nav.pensjon.regler.internal.domain.beregning2011

import no.nav.domain.pensjon.regler.repository.komponent.stottefunksjoner.koder.FormelKodeEnum
import no.nav.domain.pensjon.regler.repository.komponent.stottefunksjoner.koder.SakTypeEnum
import no.nav.domain.pensjon.regler.repository.komponent.stottefunksjoner.koder.YtelseskomponentTypeEnum
import no.nav.pensjon.regler.internal.domain.Merknad


class AfpPrivatLivsvarig : AfpLivsvarig {
    var justeringsbelop: Int = 0
    var afpProsentgrad: Double = 0.0
    var afpForholdstall: Double = 0.0

    constructor() : super(
        ytelsekomponentType = YtelseskomponentTypeEnum.AFP_PRIVAT_LIVSVARIG,
        formelKode = FormelKodeEnum.AFPx
    )

    constructor(o: AfpPrivatLivsvarig) : super(o) {
        this.justeringsbelop = o.justeringsbelop
        this.afpProsentgrad = o.afpProsentgrad
        this.afpForholdstall = o.afpForholdstall
    }

    constructor(
        justeringsbelop: Int = 0,
        afpProsentgrad: Double = 0.0,
        afpForholdstall: Double = 0.0,
        /** super Ytelseskomponent*/
        bruttoPerAr: Double = 0.0,
        fradragPerAr: Double = 0.0,
        ytelsekomponentType: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.AFP_PRIVAT_LIVSVARIG,
        merknadListe: MutableList<Merknad> = mutableListOf(),
        fradragsTransaksjon: Boolean = false,
        opphort: Boolean = false,
        sakType: SakTypeEnum? = null,
        formelKode: FormelKodeEnum? = FormelKodeEnum.AFPx,
        reguleringsInformasjon: ReguleringsInformasjon? = null
    ) : super(
        bruttoPerAr = bruttoPerAr,
        fradragPerAr = fradragPerAr,
        ytelsekomponentType = ytelsekomponentType,
        merknadListe = merknadListe,
        fradragsTransaksjon = fradragsTransaksjon,
        opphort = opphort,
        sakType = sakType,
        formelKode = formelKode,
        reguleringsInformasjon = reguleringsInformasjon
    ) {
        this.justeringsbelop = justeringsbelop
        this.afpProsentgrad = afpProsentgrad
        this.afpForholdstall = afpForholdstall
    }

}