package no.nav.pensjon.regler.to

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.beregning.*
import no.nav.pensjon.regler.domain.beregning.penobjekter.*
import no.nav.pensjon.regler.domain.beregning2011.*
import no.nav.pensjon.regler.domain.krav.Kravhode
import java.util.*

class VilkarsprovAlderpensjon2016Request : ServiceRequest() {
    var kravhode: Kravhode? = null
    var virkFom: Date? = null
    @Deprecated("Avvikles.", replaceWith = ReplaceWith("afpPrivatLivsvarig"))
    var afpLivsvarig: AfpLivsvarig? = null
    var afpPrivatLivsvarig: AfpPrivatLivsvarig? = null
    var afpVirkFom: Date? = null
    var sisteBeregning: SisteAldersberegning2016? = null
    var utforVilkarsberegning = false
}