package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.enum.GrunnlagsrolleEnum
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*
import java.time.LocalDate

class VilkarsprovHalvpensjonRequest : ServiceRequest() {
    var kravhode: Kravhode? = null
    @Deprecated("Use fomLd instead")
    var fom: Date? = null
    var fomLd: LocalDate? = null
    @Deprecated("Use tomLd instead")
    var tom: Date? = null
    var tomLd: LocalDate? = null
    var grunnlagsrolleEnum: GrunnlagsrolleEnum? = null

    /**
     * vilkårsvedtak for uføretrygd.
     */
    var vilkarsvedtak: VilkarsVedtak? = null
}