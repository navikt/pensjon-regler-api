package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.krav.Kravhode
import java.util.*

class VilkarsprovEktefelletillegg2011Request : ServiceRequest() {
    var kravhode: Kravhode? = null
    var fom: Date? = null
    var tom: Date? = null

}