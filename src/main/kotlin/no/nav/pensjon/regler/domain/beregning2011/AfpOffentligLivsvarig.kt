package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import java.time.LocalDate

open class AfpOffentligLivsvarig : AbstraktAfpLivsvarig() {
    var sistRegulertG: Int? = null
    var uttaksdato: LocalDate? = null

    override val ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.AFP_OFFENTLIG_LIVSVARIG

}