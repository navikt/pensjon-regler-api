package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.simulering.Simuleringsresultat
import java.io.Serializable

class SimuleringResponse : Serializable {
    var simuleringsResultat: Simuleringsresultat? = null
    var pakkseddel: Pakkseddel? = null
}