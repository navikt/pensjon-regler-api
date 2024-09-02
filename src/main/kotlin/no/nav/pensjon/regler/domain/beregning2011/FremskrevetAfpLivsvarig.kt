package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

class FremskrevetAfpLivsvarig : AfpLivsvarig(), Regulering {
    override var reguleringsfaktor = 0.0
    override var gap = 0
    var gjennomsnittligUttaksgradSisteAr = 0.0

    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("FREM_AFP_LIVSVARIG")
    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.FREM_AFP_LIVSVARIG
}