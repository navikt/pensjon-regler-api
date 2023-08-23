package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import java.io.Serializable

/**
 *
 * Opprettet for CR195877
 *
 */
class SimulerAP2011For2025Response : Serializable {
    var pakkseddel: Pakkseddel? = null
    var ap2011Response: BeregnAlderspensjon2011ForsteUttakResponse? = null

}