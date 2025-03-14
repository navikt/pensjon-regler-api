package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.enum.GrunnlagsrolleEnum
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

class VilkarsprovHalvpensjonRequest : ServiceRequest() {
    var kravhode: Kravhode? = null
    var fom: Date? = null
    var tom: Date? = null
    var grunnlagsrolleEnum: GrunnlagsrolleEnum? = null

    /**
     * vilkårsvedtak for uføretrygd.
     */
    var vilkarsvedtak: VilkarsVedtak? = null
}