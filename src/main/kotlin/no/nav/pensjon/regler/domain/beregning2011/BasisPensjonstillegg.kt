package no.nav.pensjon.regler.domain.beregning2011

class BasisPensjonstillegg : Pensjonstillegg {
    constructor()
    constructor(pt: Pensjonstillegg) : super(pt) {
        // Fjerner brutto og netto
        brutto = 0
        netto = 0
    }
}