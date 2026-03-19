package no.nav.pensjon.regler.to

import com.fasterxml.jackson.annotation.JsonAlias
import no.nav.pensjon.regler.domain.beregning2011.AfpOffentligLivsvarigGrunnlag
import no.nav.pensjon.regler.domain.beregning2011.AfpPrivatLivsvarig
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2011
import no.nav.pensjon.regler.domain.krav.Kravhode
import java.util.*
import java.time.LocalDate

class VilkarsprovAlderpensjon2025Request : ServiceRequest() {
    var kravhode: Kravhode? = null
    @Deprecated("Use virkLd instead")
    @JsonAlias("fom")
    var virk: Date? = null
    @JsonAlias("fomLd")
    var virkLd: LocalDate? = null
    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
    @Deprecated("Use afpVirkFomLd instead")
    var afpVirkFom: Date? = null
    var afpVirkFomLd: LocalDate? = null
    var sisteBeregning: SisteAldersberegning2011? = null
    var utforVilkarsberegning = false
    var afpOffentligLivsvarigGrunnlag: AfpOffentligLivsvarigGrunnlag? = null
}