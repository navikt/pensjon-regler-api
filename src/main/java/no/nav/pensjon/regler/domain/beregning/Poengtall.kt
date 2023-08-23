package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.Omsorgsopptjening
import no.nav.pensjon.regler.domain.kode.BeregningMetodeTypeCti
import no.nav.pensjon.regler.domain.kode.PoengtallTypeCti
import java.io.Serializable

class Poengtall : Serializable, Omsorgsopptjening {
    /**
     * Pensjonspoeng,
     */
    @JvmField
    var pp = 0.0

    /**
     * Anvendt pensjonsgivende inntekt.
     */
    var pia = 0

    /**
     * Pensjonsgivende inntekt.
     */
    var pi = 0

    /**
     * året for dette poengtallet
     */
    @JvmField
    var ar = 0

    /**
     * Angir om poengtallet er brukt i beregningen av sluttpoengtall.
     */
    var bruktIBeregning = false

    /**
     * Veiet grunnbeløp
     */
    var gv = 0

    /**
     * Poengtalltype.
     */
    @JvmField
    var poengtallType: PoengtallTypeCti? = null

    /**
     * Maks Uføregrad for dette året
     */
    var maksUforegrad = 0

    /**
     * året regnet som poengår.
     */
    var pREG_poengar = false

    /**
     * året regnet som poengår iht. trygdeavtale.
     */
    var isPREG_poengarUtland = false

    /**
     * Poengtall uten garanti. Internt bruk i PREG.
     */
    var pREG_pp_fa = 0.0

    /**
     * Gradert poengtall. Internt bruk i PREG.
     */
    var pREG_pp_gradert = 0.0

    /**
     * Omregnet poengtall. Internt bruk i PREG.
     */
    var pREG_pp_omregnet = 0.0

    /**
     * uførepensjon faktor (grad). Internt bruk i PREG.
     */
    var pREG_up_faktor = 0.0

    /**
     * Yrkesskadepensjon faktor (grad). Internt bruk i PREG.
     */
    var pREG_ysk_faktor = 0.0

    /**
     * Angir om året er et Uføreår.
     */
    var isUforear = false

    /**
     * Angir om poengtallet er blitt avkortet i henhold til regler for f92.
     * Benyttes i sammenheng med beregning av FPP. Internt bruk i PREG.
     */
    var isPREG_avkortet = false

    /**
     * Angir om poengtallet er i et omsorgsær
     */
    var isPREG_omsorg = false

    /**
     * Angir hvilken beregningsmetode (folketrygd, EØS, nordisk, ...) det
     * opptjente poenget forbindes med. Internt bruk i PREG.
     */
    var pREG_beregningsmetode: BeregningMetodeTypeCti? = null
    var isPREG_omregnet = false
    var isPREG_ikkeProrata = false
    var isPREG_ikkeAlternativProrata = false

    /**
     * Brutto pensjonspoeng.
     */
    var pREG_brp = 0.0

    /**
     * Faktiske brutto pensjonspoeng. Ikke oppjustert av omsorgspoeng.
     */
    var pREG_brp_fa = 0.0

    /**
     * Angir om året beregnes tilsvarende Uførestartør. Gjelder historiske Uføreperioder.
     */
    var isPREG_tilsvarerUforear = false

    /**
     * Angir den effektive FPP som blir godskrevet i året.
     */
    var pREG_effektivFPP = 0.0

    /**
     * Angir den effektive PAA som blir godskrevet i året.
     */
    var pREG_effektivPAA = 0.0

    var merknadListe: MutableList<Merknad> = mutableListOf()

    override fun getVerdi(): Double {
        return pp
    }

    override fun isOmsorg(): Boolean {
        return isPREG_omsorg
    }

    /**
     * {@inheritDoc}
     */
    override fun getOpptjeningsar(): Int {
        return ar
    }

    constructor()
    constructor(poengtall: Poengtall) {
        pp = poengtall.pp
        pia = poengtall.pia
        pi = poengtall.pi
        ar = poengtall.ar
        bruktIBeregning = poengtall.bruktIBeregning
        gv = poengtall.gv
        if (poengtall.poengtallType != null) {
            poengtallType = PoengtallTypeCti(poengtall.poengtallType!!)
        }
        maksUforegrad = poengtall.maksUforegrad
        isUforear = poengtall.isUforear
        merknadListe = ArrayList()
        for (merknad in poengtall.merknadListe) {
            merknadListe.add(Merknad(merknad))
        }
    }
}