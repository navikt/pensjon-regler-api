package no.nav.pensjon.regler.domain.beregning2011

import java.io.Serializable

class JustertMinstePensjonsniva : Serializable {
    var minstePensjonsniva: MinstePensjonsniva? = null
    var justeringsInformasjon: JusteringsInformasjon? = null
    var belop = 0.0
    constructor()
    constructor(fmpn: JustertMinstePensjonsniva) : super() {
        belop = fmpn.belop
        if (fmpn.minstePensjonsniva != null) {
            minstePensjonsniva = MinstePensjonsniva(fmpn.minstePensjonsniva!!)
        }
        if (fmpn.justeringsInformasjon != null) {
            justeringsInformasjon = JusteringsInformasjon(fmpn.justeringsInformasjon!!)
        }
    }
}