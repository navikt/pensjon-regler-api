package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import java.io.Serializable

class FremskrevetPensjonUnderUtbetaling : Serializable, Regulering {
    var pensjonUnderUtbetalingPerAr = 0.0
    override var gap = 0
    override var reguleringsfaktor = 0.0
    var formelKodeEnum: FormelKodeEnum = FormelKodeEnum.BPUx
}