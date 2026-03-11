package no.nav.pensjon.regler.domain.beregning2011

import java.io.Serializable
import java.util.*
import java.time.LocalDate

class FremskrivingsDetaljer : Serializable, IFremskriving {
    @Deprecated("Use justeringTomDatoLd instead")
    override var justeringTomDato: Date? = null
    override var justeringTomDatoLd: LocalDate? = null
    override var justeringsfaktor = 0.0
    override var teller = 0.0
    override var nevner = 0.0
    var arskull = 0

    constructor()
    constructor(frem: FremskrivingsDetaljer) : this() {
        if (frem.justeringTomDato != null) {
            justeringTomDato = frem.justeringTomDato!!.clone() as Date
        }
        if(frem.justeringTomDatoLd != null) {
            justeringTomDatoLd = frem.justeringTomDatoLd
        }
        justeringsfaktor = frem.justeringsfaktor
        teller = frem.teller
        nevner = frem.nevner
        arskull = frem.arskull
    }
}