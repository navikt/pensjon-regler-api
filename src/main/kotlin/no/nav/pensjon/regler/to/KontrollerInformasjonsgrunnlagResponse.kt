package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.Pakkseddel
import java.io.Serializable
import java.util.*

class KontrollerInformasjonsgrunnlagResponse : Serializable {
    var merknadListe: List<Merknad> = Vector()

    /**
     * Pakkseddel for beregningene.
     */
    var pakkseddel = Pakkseddel()
}