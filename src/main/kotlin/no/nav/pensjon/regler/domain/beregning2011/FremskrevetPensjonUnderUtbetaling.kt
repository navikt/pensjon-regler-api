package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import java.io.Serializable

class FremskrevetPensjonUnderUtbetaling : Serializable, Regulering {
    var pensjonUnderUtbetalingPerAr = 0.0
    override var gap = 0
    override var reguleringsfaktor = 0.0
    var formelKode: FormelKodeCti = FormelKodeCti("BPUx")
}