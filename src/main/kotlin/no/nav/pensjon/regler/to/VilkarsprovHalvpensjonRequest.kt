package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.kode.GrunnlagsrolleCti
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

class VilkarsprovHalvpensjonRequest : ServiceRequest() {
    var kravhode: Kravhode? = null
    var fom: Date? = null
    var tom: Date? = null
    var grunnlagsrolle: GrunnlagsrolleCti? = null

    /**
     * vilkårsvedtak for uføretrygd.
     */
    var vilkarsvedtak: VilkarsVedtak? = null
}