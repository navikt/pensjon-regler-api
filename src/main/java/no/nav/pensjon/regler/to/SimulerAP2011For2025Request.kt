package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.grunnlag.DelingstallUtvalg
import no.nav.pensjon.regler.domain.grunnlag.GarantitilleggsbeholdningGrunnlag

/**
 *
 * Opprettet for CR195877
 *
 */
class SimulerAP2011For2025Request {
    var ap2011Request: BeregnAlderspensjon2011ForsteUttakRequest? = null
    var garantitilleggsbeholdningGrunnlag: GarantitilleggsbeholdningGrunnlag? = null
    var delingstallUtvalg: DelingstallUtvalg? = null
}