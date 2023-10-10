package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.beregning2011.JustertGarantipensjonsniva
import no.nav.pensjon.regler.domain.grunnlag.Beholdninger

class VilkarsprovInformasjon2025 : VilkarsprovInformasjon() {
    var garPN67: JustertGarantipensjonsniva? = null
    var garPN67ProRata: JustertGarantipensjonsniva? = null
    var beholdningerVed67: Beholdninger? = null

}