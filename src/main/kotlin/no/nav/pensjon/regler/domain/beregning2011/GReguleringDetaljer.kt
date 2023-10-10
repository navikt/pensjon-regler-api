package no.nav.pensjon.regler.domain.beregning2011

import java.io.Serializable
import java.util.*

class GReguleringDetaljer : Serializable, IGRegulering {
    override var justeringTomDato: Date? = null
    override var justeringsfaktor = 0.0
    override var forrigeG = 0
    override var gjeldendeG = 0

}