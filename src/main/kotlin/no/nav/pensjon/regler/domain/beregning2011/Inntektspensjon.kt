package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import no.nav.pensjon.regler.domain.trygdetid.Brok

class Inntektspensjon : Ytelseskomponent() {
    /**
     * brøken angir PenB_EKSPORT / PenB_NORGE som inntektspensjonen er redusert med.
     */
    var eksportBrok: Brok? = null

    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.IP

}