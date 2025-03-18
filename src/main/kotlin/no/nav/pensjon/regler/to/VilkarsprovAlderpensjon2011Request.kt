package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.AfpLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2011
import no.nav.pensjon.regler.domain.krav.Kravhode
import java.util.*

class VilkarsprovAlderpensjon2011Request : ServiceRequest() {
    var kravhode: Kravhode? = null
    var fom: Date? = null
    var tom: Date? = null
    var afpVirkFom: Date? = null
    @Deprecated("Avvikles. Erstattes av afpPrivatLivsvarig.")
    var afpLivsvarig: AfpLivsvarig? = null
    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
    var sisteBeregning: SisteAldersberegning2011? = null
    var utforVilkarsberegning = false
}