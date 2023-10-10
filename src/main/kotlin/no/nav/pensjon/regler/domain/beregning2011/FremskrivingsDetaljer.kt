package no.nav.pensjon.regler.domain.beregning2011

import java.io.Serializable
import java.util.*

open class FremskrivingsDetaljer() : Serializable, IFremskriving {
    override var justeringTomDato: Date? = null
    override var justeringsfaktor = 0.0
    override var teller = 0.0
    override var nevner = 0.0
    var arskull = 0
}