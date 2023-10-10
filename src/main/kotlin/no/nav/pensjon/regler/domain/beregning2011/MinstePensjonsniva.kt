package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import no.nav.pensjon.regler.domain.kode.MinstepenNivaCti
import java.io.Serializable

class MinstePensjonsniva : Serializable {
    var belop = 0.0
    var sats = 0.0
    var benyttetYug = 0
    var pro_rata_teller_mnd = 0
    var pro_rata_nevner_mnd = 0
    var pro_rata_brok = 0.0
    var formelKode: FormelKodeCti? = null

    /** Minstepensjonsnivå. Kan være lav, ordinær og forhøyet. Benytter tabellen  */
    var satsType: MinstepenNivaCti? = null
    var merknadListe: MutableList<Merknad> = mutableListOf()
    var faktisk_tt_avtaleland_mnd = 0

    init {
        formelKode = FormelKodeCti("MPNx")
    }

    constructor()
    constructor(mpn: MinstePensjonsniva) : super() {
        belop = mpn.belop
        sats = mpn.sats
        benyttetYug = mpn.benyttetYug
        pro_rata_teller_mnd = mpn.pro_rata_teller_mnd
        pro_rata_nevner_mnd = mpn.pro_rata_nevner_mnd
        pro_rata_brok = mpn.pro_rata_brok
        if (mpn.satsType != null) {
            satsType = MinstepenNivaCti(mpn.satsType!!)
        }
        if (mpn.formelKode != null) {
            formelKode = FormelKodeCti(mpn.formelKode!!)
        }
        for (merknad in mpn.merknadListe) {
            merknadListe.add(Merknad(merknad))
        }
        faktisk_tt_avtaleland_mnd = mpn.faktisk_tt_avtaleland_mnd
    }
}