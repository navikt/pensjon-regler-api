package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Grunnpensjon

class BasisGrunnpensjon : Grunnpensjon {
    /**
     * En versjon av Grunnpensjon uten tilgang til brutto og netto siden Basispensjonsytelsene kun
     * er definert med årsbeløp
     */
    constructor(gp: Grunnpensjon) : super(gp) {
        // Fjerner brutto og netto
        super.brutto = 0
        super.netto = 0
    }

    constructor()
}