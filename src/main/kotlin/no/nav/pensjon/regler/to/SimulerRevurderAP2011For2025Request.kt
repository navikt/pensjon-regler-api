package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.DelingstallUtvalg
import no.nav.pensjon.regler.domain.grunnlag.GarantitilleggsbeholdningGrunnlag

/**
 *
 * Opprettet for CR195877
 *
 */
class SimulerRevurderAP2011For2025Request : ServiceRequest() {
    var ap2011Request: RevurderingAlderspensjon2011Request? = null
    var garantitilleggsbeholdningGrunnlag: GarantitilleggsbeholdningGrunnlag? = null
    var delingstallUtvalg: DelingstallUtvalg? = null
}