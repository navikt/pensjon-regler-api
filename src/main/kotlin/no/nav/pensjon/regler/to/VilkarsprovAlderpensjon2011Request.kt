package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2011
import no.nav.pensjon.regler.domain.krav.Kravhode
import java.time.LocalDate
import java.util.*

class VilkarsprovAlderpensjon2011Request : ServiceRequest() {
    var kravhode: Kravhode? = null

    @Deprecated("Use fomLd instead")
    var fom: Date? = null
    var fomLd: LocalDate? = null

    @Deprecated("Use tomLd instead")
    var tom: Date? = null
    var tomLd: LocalDate? = null

    @Deprecated("Use afpVirkFomLd instead")
    var afpVirkFom: Date? = null
    var afpVirkFomLd: LocalDate? = null

    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
    var sisteBeregning: SisteAldersberegning2011? = null
    var utforVilkarsberegning = false
}