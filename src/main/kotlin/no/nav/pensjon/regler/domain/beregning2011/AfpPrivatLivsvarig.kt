package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum

class AfpPrivatLivsvarig : AbstraktAfpLivsvarig() {
    var justeringsbelop: Int = 0
    var afpProsentgrad: Double = 0.0
    var afpForholdstall: Double = 0.0

    override val ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.AFP_PRIVAT_LIVSVARIG
}