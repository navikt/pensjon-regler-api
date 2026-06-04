package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.beregning2011.JustertGarantipensjonsniva
import no.nav.pensjon.regler.domain.grunnlag.Beholdninger

class VilkarsprovInformasjon2025 : VilkarsprovInformasjon() {
    var garPNvedNormertPensjonsalder: JustertGarantipensjonsniva? = null
    var garPNvedNormertPensjonsalderProRata: JustertGarantipensjonsniva? = null
    var beholdningerVedNormertPensjonsalder: Beholdninger? = null
}