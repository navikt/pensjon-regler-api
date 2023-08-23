package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.io.Serializable

class VilkarsprovHalvpensjonResponse : Serializable {
    var vilkarsvedtak: VilkarsVedtak? = null
    var pakkseddel: Pakkseddel? = null
}