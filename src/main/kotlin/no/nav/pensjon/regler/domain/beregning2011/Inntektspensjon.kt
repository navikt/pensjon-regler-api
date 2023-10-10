package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import no.nav.pensjon.regler.domain.trygdetid.Brok

class Inntektspensjon : Ytelseskomponent() {
    /**
     * brøken angir PenB_EKSPORT / PenB_NORGE som inntektspensjonen er redusert med.
     */
    var eksportBrok: Brok? = null

    init {
        ytelsekomponentType = YtelsekomponentTypeCti("IP")
    }
}