package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.io.Serializable
import java.util.*

class VilkarsprovResponse : Serializable {
    var vedtaksliste: List<VilkarsVedtak> = Vector()

    /**
     * Pakkseddel for beregningene.
     */
    var pakkseddel = Pakkseddel()
}