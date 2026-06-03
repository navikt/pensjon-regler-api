package no.nav.pensjon.regler.domain.beregning2011

import java.io.Serializable
import java.time.LocalDate

class LonnsvekstDetaljer : Serializable, ILonnsvekst {
    override var justeringTomDatoLd: LocalDate? = null
    override var justeringsfaktor = 0.0
    override var lonnsvekst = 0.0

    constructor()

    constructor(lvd: LonnsvekstDetaljer) : this() {
        if(lvd.justeringTomDatoLd != null) {
            justeringTomDatoLd = lvd.justeringTomDatoLd
        }
        justeringsfaktor = lvd.justeringsfaktor
        lonnsvekst = lvd.lonnsvekst
    }

    constructor(
        justeringsfaktor: Double = 0.0,
        lonnsvekst: Double = 0.0) {
        this.justeringsfaktor = justeringsfaktor
        this.lonnsvekst = lonnsvekst
    }
}