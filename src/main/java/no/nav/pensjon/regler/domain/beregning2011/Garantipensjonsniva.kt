package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.GarantipenNivaCti
import java.io.Serializable

class Garantipensjonsniva : Serializable {
    var ektefelleInntektOver2G = false
    var belop = 0.0
    var belopIkkeProratisert = 0.0
    var sats = 0.0
    var satsType: GarantipenNivaCti? = null
    var formelkode: FormelKodeCti? = null
    var pro_rata_teller_mnd = 0
    var pro_rata_nevner_mnd = 0
    var pro_rata_brok = 0.0
    var tt_anv = 0
    var faktisk_tt_avtaleland_mnd = 0
    var benyttetYug = 0
}