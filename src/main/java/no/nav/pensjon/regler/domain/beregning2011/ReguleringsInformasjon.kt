package no.nav.pensjon.regler.domain.beregning2011

import java.io.Serializable

class ReguleringsInformasjon : Serializable {
    var lonnsvekst = 0.0
    var fratrekksfaktor = 0.0
    var gammelG = 0
    var nyG = 0
    var reguleringsfaktor = 0.0
    var gjennomsnittligUttaksgradSisteAr = 0.0
    var reguleringsbelop = 0.0
    var prisOgLonnsvekst = 0.0

    constructor()
    constructor(r: ReguleringsInformasjon) {
        lonnsvekst = r.lonnsvekst
        fratrekksfaktor = r.fratrekksfaktor
        gammelG = r.gammelG
        nyG = r.nyG
        reguleringsfaktor = r.reguleringsfaktor
        gjennomsnittligUttaksgradSisteAr = r.gjennomsnittligUttaksgradSisteAr
        reguleringsbelop = r.reguleringsbelop
        prisOgLonnsvekst = r.prisOgLonnsvekst
    }
}