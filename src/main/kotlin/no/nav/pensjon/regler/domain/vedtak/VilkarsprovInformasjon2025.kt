package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.beregning2011.JustertGarantipensjonsniva
import no.nav.pensjon.regler.domain.grunnlag.Beholdninger

class VilkarsprovInformasjon2025 : VilkarsprovInformasjon() {
    @Deprecated("Avvikles. Erstattes av garPNvedNormertPensjonsalder.")
    var garPN67: JustertGarantipensjonsniva? = null
    var garPNvedNormertPensjonsalder: JustertGarantipensjonsniva? = null
    @Deprecated("Avvikles. Erstattes av garPNvedNormertPensjonsalderProRata.")
    var garPN67ProRata: JustertGarantipensjonsniva? = null
    var garPNvedNormertPensjonsalderProRata: JustertGarantipensjonsniva? = null
    var beholdningerVed67: Beholdninger? = null

}