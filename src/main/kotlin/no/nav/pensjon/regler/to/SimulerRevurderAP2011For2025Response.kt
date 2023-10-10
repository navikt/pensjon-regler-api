package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import java.io.Serializable

/**
 *
 * Opprettet for CR195877
 *
 */
class SimulerRevurderAP2011For2025Response : Serializable {
    var pakkseddel: Pakkseddel? = null
    var ap2011Response: RevurderingAlderspensjon2011Response? = null
}