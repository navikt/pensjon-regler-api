package no.nav.pensjon.regler.domain.beregning2011

interface IGRegulering : IJustering {
    var forrigeG: Int
    var gjeldendeG: Int
}