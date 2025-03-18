package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum

class FremskrevetAfpLivsvarig : AbstraktAfpLivsvarig(), Regulering {
    override var reguleringsfaktor = 0.0
    override var gap = 0
    var gjennomsnittligUttaksgradSisteAr = 0.0

    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.FREM_AFP_LIVSVARIG
}