package no.nav.pensjon.regler.domain.beregning2011

import java.io.Serializable

/**
 * @author Aasmund Nordstoga (Accenture) PK-5549
 */
class Justertbelop : Serializable {
    var g01052014 = 0
    var gjennomsnittligG2014 = 0
    var justertbelop = 0.0
    var overgangsbelop: Overgangsbelop? = null
}