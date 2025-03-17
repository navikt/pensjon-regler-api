package no.nav.pensjon.regler.internal.domain.beregning2011

import no.nav.domain.pensjon.regler.repository.komponent.stottefunksjoner.koder.FormelKodeEnum
import no.nav.domain.pensjon.regler.repository.komponent.stottefunksjoner.koder.SakTypeEnum
import no.nav.domain.pensjon.regler.repository.komponent.stottefunksjoner.koder.YtelseskomponentTypeEnum
import no.nav.pensjon.regler.internal.domain.Merknad

import java.time.LocalDate

open class AfpOffentligLivsvarig : AfpLivsvarig {
    var sistRegulertG: Int? = null

    constructor() : super(
        ytelsekomponentType = YtelseskomponentTypeEnum.AFP_OFFENTLIG_LIVSVARIG,
        formelKode = FormelKodeEnum.AFPx
    )

    constructor(o: AfpOffentligLivsvarig) : super(o) {
        this.sistRegulertG = o.sistRegulertG
    }

    constructor(
        sistRegulertG: Int? = null,
        /** super Ytelseskomponent*/
        bruttoPerAr: Double = 0.0,
        fradragPerAr: Double = 0.0,
        ytelsekomponentType: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.AFP_OFFENTLIG_LIVSVARIG,
        merknadListe: MutableList<Merknad> = mutableListOf(),
        fradragsTransaksjon: Boolean = false,
        opphort: Boolean = false,
        sakType: SakTypeEnum? = null,
        formelKode: FormelKodeEnum = FormelKodeEnum.AFPx,
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
        this.sistRegulertG = sistRegulertG
    }
}