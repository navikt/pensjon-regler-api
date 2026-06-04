package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2016
import no.nav.pensjon.regler.domain.krav.Kravhode
import java.util.*
import java.time.LocalDate

class VilkarsprovAlderpensjon2016Request : ServiceRequest() {
    var kravhode: Kravhode? = null
    var virkFomLd: LocalDate? = null
    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
    var afpVirkFomLd: LocalDate? = null
    var sisteBeregning: SisteAldersberegning2016? = null
    var utforVilkarsberegning = false
}