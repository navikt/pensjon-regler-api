package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import no.nav.pensjon.regler.domain.enum.MinstePensjonsnivaSatsEnum
import java.io.Serializable

class MinstePensjonsniva : Serializable {
    var belop = 0.0
    var sats = 0.0
    var benyttetYug = 0
    var pro_rata_teller_mnd = 0
    var pro_rata_nevner_mnd = 0
    var pro_rata_brok = 0.0
    var formelKodeEnum: FormelKodeEnum = FormelKodeEnum.MPNx

    /** Minstepensjonsnivå. Kan være lav, ordinær og forhøyet. Benytter tabellen  */
    var satsTypeEnum: MinstePensjonsnivaSatsEnum? = null
    var merknadListe: MutableList<Merknad> = mutableListOf()
    var faktisk_tt_avtaleland_mnd = 0

    constructor()
    constructor(mpn: MinstePensjonsniva) : super() {
        belop = mpn.belop
        sats = mpn.sats
        benyttetYug = mpn.benyttetYug
        pro_rata_teller_mnd = mpn.pro_rata_teller_mnd
        pro_rata_nevner_mnd = mpn.pro_rata_nevner_mnd
        pro_rata_brok = mpn.pro_rata_brok
        if (mpn.satsTypeEnum != null) {
            satsTypeEnum = mpn.satsTypeEnum
        }
        formelKodeEnum = mpn.formelKodeEnum
        for (merknad in mpn.merknadListe) {
            merknadListe.add(Merknad(merknad))
        }
        faktisk_tt_avtaleland_mnd = mpn.faktisk_tt_avtaleland_mnd
    }
}