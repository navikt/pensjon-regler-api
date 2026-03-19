package no.nav.pensjon.regler.to

import com.fasterxml.jackson.annotation.JsonAlias
import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2011
import no.nav.pensjon.regler.domain.krav.Kravhode
import java.time.LocalDate
import java.util.*

class VilkarsprovAlderpensjon2011Request : ServiceRequest() {
    var kravhode: Kravhode? = null

    @Deprecated("Use virkLd instead")
    @JsonAlias("fom")
    var virk: Date? = null
    @JsonAlias("fomLd")
    var virkLd: LocalDate? = null

    @Deprecated("Use tomLd instead. Tom er ikke i bruk for denne tjenesten.")
    @JsonAlias("tom")
    var tom: Date? = null
    var tomLd: LocalDate? = null

    @Deprecated("Use afpVirkFomLd instead")
    var afpVirkFom: Date? = null
    var afpVirkFomLd: LocalDate? = null

    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
    var sisteBeregning: SisteAldersberegning2011? = null
    var utforVilkarsberegning = false
}