package no.nav.pensjon.regler.to

import com.fasterxml.jackson.annotation.JsonAlias
import no.nav.pensjon.regler.domain.enum.GrunnlagsrolleEnum
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*
import java.time.LocalDate

class VilkarsprovHalvpensjonRequest : ServiceRequest() {
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
    var grunnlagsrolleEnum: GrunnlagsrolleEnum? = null

    /**
     * vilkårsvedtak for uføretrygd.
     */
    var vilkarsvedtak: VilkarsVedtak? = null
}