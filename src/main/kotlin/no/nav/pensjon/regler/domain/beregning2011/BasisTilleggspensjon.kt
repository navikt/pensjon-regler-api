package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Tilleggspensjon

class BasisTilleggspensjon : Tilleggspensjon {
    constructor()
    constructor(tilleggspensjon: Tilleggspensjon) : super(tilleggspensjon) {
        // Fjerner brutto og netto
        brutto = 0
        netto = 0
    }
}