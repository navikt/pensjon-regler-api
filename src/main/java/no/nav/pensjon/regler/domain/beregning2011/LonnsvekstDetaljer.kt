package no.nav.pensjon.regler.domain.beregning2011

import java.io.Serializable
import java.util.*

class LonnsvekstDetaljer : Serializable, ILonnsvekst {
    override var justeringTomDato: Date? = null
    override var justeringsfaktor = 0.0
    override var lonnsvekst = 0.0
}