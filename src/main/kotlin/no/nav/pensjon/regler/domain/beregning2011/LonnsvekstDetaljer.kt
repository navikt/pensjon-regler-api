package no.nav.pensjon.regler.domain.beregning2011

import java.io.Serializable
import java.util.*
import java.time.LocalDate

class LonnsvekstDetaljer : Serializable, ILonnsvekst {
    @Deprecated("Use justeringTomDatoLd instead")
    override var justeringTomDato: Date? = null
    override var justeringTomDatoLd: LocalDate? = null
    override var justeringsfaktor = 0.0
    override var lonnsvekst = 0.0

    constructor()

    constructor(lvd: LonnsvekstDetaljer) : this() {
        if (lvd.justeringTomDato != null) {
            justeringTomDato = lvd.justeringTomDato!!.clone() as Date
        }
        justeringsfaktor = lvd.justeringsfaktor
        lonnsvekst = lvd.lonnsvekst
    }

    constructor(
        justeringTomDato: Date? = null,
        justeringsfaktor: Double = 0.0,
        lonnsvekst: Double = 0.0) {
        this.justeringTomDato = justeringTomDato
        this.justeringsfaktor = justeringsfaktor
        this.lonnsvekst = lonnsvekst
    }
}