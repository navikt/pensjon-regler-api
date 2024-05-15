package no.nav.pensjon.regler.to

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.beregning.*
import no.nav.pensjon.regler.domain.beregning.penobjekter.*
import no.nav.pensjon.regler.domain.beregning2011.*
import no.nav.pensjon.regler.domain.grunnlag.DelingstallUtvalg
import no.nav.pensjon.regler.domain.grunnlag.ForholdstallUtvalg
import no.nav.pensjon.regler.domain.grunnlag.GarantitilleggsbeholdningGrunnlag
import no.nav.pensjon.regler.domain.krav.Kravhode
import java.util.*

class VilkarsprovAlderpensjon2016Request : ServiceRequest() {
    var kravhode: Kravhode? = null
    var virkFom: Date? = null
    var forholdstallUtvalg: ForholdstallUtvalg? = null
    var delingstallUtvalg: DelingstallUtvalg? = null
    var afpLivsvarig: AfpLivsvarig? = null
    var afpVirkFom: Date? = null
    var sisteBeregning: SisteAldersberegning2016? = null
    var utforVilkarsberegning = false
    var garantitilleggsbeholdningGrunnlag: GarantitilleggsbeholdningGrunnlag? = null
}