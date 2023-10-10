package no.nav.pensjon.regler.domain.beregning2011

import java.util.*

interface IJustering {
    var justeringsfaktor: Double
    var justeringTomDato: Date?
}