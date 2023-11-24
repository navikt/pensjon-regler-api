package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.Merknad
import java.io.Serializable
import java.util.*

class Poengrekke : Serializable {
    /**
     * @return Returns the pa.
     */
    /**
     * @param pa
     * The pa to set.
     */
    /**
     * Antall poengår totalt. Kan være ikke være over 40.
     */
    var pa = 0
    /**
     * @return Returns the pa_f92.
     */
    /**
     * @param pa_f92
     * The pa_f92 to set.
     */
    /**
     * Antall poengår før 1992.
     */
    var pa_f92 = 0
    /**
     * @return Returns the pa_e91.
     */
    /**
     * @param pa_e91
     * The pa_e91 to set.
     */
    /**
     * Antall poengår etter 1991.
     */
    var pa_e91 = 0
    /**
     * @return Returns the pa_fa_norge.
     */
    /**
     * @param pa_fa_norge
     * The pa_fa_norge to set.
     */
    /**
     * Faktiske poengår i Norge.
     */
    var pa_fa_norge = 0
    /**
     * @return Returns the tpi.
     */
    /**
     * @param tpi
     * The tpi to set.
     */
    /**
     * Tidligere pensjonsgivende inntekt.
     */
    var tpi = 0

    /**
     * Liste av Poengtall
     */
     var poengtallListe: MutableList<Poengtall> = mutableListOf()

    /**
     * Samlet antall poengår i Norge.
     */
    var pa_no = 0

    /**
     * Framtidig pensjonspoengtall. Brukes ved beregning av
     * uførepensjon,gjenlevendepensjon og AFP.
     */
    var fpp: FramtidigPensjonspoengtall? = null

    /**
     * Framtidig pensjonspoengtall, basert på omregnet poengrekke. Brukes ved
     * beregning av uførepensjon og gjenlevendepensjon.
     */
    var fpp_omregnet: FramtidigPensjonspoengtall? = null

    /**
     * Siste poengår med framtidig pensjonspoeng.
     */
    var siste_fpp_aar = 0

    /**
     * Tidligere pensjonsgivende inntekt, beregnet som en faktor.
     */
    var tpi_faktor = 0.0

    /**
     * Brutto antall framtidige poengår i norden.
     */
    var pa_nordisk_framt_brutto = 0

    /**
     * Netto antall framtidige poengår i norden.
     */
    var pa_nordisk_framt_netto = 0

    /**
     * Poengtall ut fra antatt årlig inntekt.
     */
    var paa = 0.0

    /**
     * Faktiske poengår i Norden.
     */
    var pa_fa_norden = 0

    /**
     * Teoretiske poengår EØS. Dette begrepet brukes ved beregning av
     * tilleggspensjon etter EØS-reglene eller ved beregning etter de bilaterale
     * avtalene. Ved pro rata beregningen fastsettes det teoretiske antallet
     * poengår som det antall år vedkommende ville fått dersom all opptjening i
     * EØS-land hadde vært opptjent i Norge
     */
    var pa_eos_teoretisk = 0

    /**
     * Pro-rata poengår EØS. Poengår som ikke skal inngå i pro-rata beregning er
     * utelatt.
     */
    var pa_eos_pro_rata = 0

    /**
     * Teller i pro-rata brøk.
     */
    var pa_pro_rata_teller = 0

    /**
     * Nevner i pro-rata brøk.
     */
    var pa_pro_rata_nevner = 0

    /**
     * Antall fremtidige poengår.
     */
    var fpa = 0

    /**
     * Liste av merknader.
     */
     var merknadListe: MutableList<Merknad> = mutableListOf()

    /**
     * Flagg som viser om oppustert grunnlag fra pensjonsberegning fra TP-ordning er benyttet
     */
    var afpTpoUpGrunnlagAnvendt = false

    /**
     * Det oppjusterte uførepensjonsgrunnlaget fra TP-ordningen som ble brukt i beregning av TPI
     */
    var afpTpoUpGrunnlagOppjustert = 0

    /**
     * TPI beregnet etter hovedregelen
     */
    var tpiEtterHovedregel = 0

    constructor()
    constructor(poengrekke: Poengrekke) {
        pa = poengrekke.pa
        pa_f92 = poengrekke.pa_f92
        pa_e91 = poengrekke.pa_e91
        pa_fa_norge = poengrekke.pa_fa_norge
        tpi = poengrekke.tpi
        poengtallListe = mutableListOf()
        for (poengtall in poengrekke.poengtallListe) {
            poengtallListe.add(Poengtall(poengtall))
        }
        pa_no = poengrekke.pa_no
        if (poengrekke.fpp != null) {
            fpp = FramtidigPensjonspoengtall(poengrekke.fpp!!)
        }
        if (poengrekke.fpp_omregnet != null) {
            fpp_omregnet = FramtidigPensjonspoengtall(poengrekke.fpp_omregnet!!)
        }
        siste_fpp_aar = poengrekke.siste_fpp_aar
        tpi_faktor = poengrekke.tpi_faktor
        pa_nordisk_framt_brutto = poengrekke.pa_nordisk_framt_brutto
        pa_nordisk_framt_netto = poengrekke.pa_nordisk_framt_netto
        paa = poengrekke.paa
        pa_fa_norden = poengrekke.pa_fa_norden
        pa_eos_teoretisk = poengrekke.pa_eos_teoretisk
        pa_eos_pro_rata = poengrekke.pa_eos_pro_rata
        pa_pro_rata_teller = poengrekke.pa_pro_rata_teller
        pa_pro_rata_nevner = poengrekke.pa_pro_rata_nevner
        fpa = poengrekke.fpa
        afpTpoUpGrunnlagAnvendt = poengrekke.afpTpoUpGrunnlagAnvendt
        afpTpoUpGrunnlagOppjustert = poengrekke.afpTpoUpGrunnlagOppjustert
        tpiEtterHovedregel = poengrekke.tpiEtterHovedregel
        merknadListe = mutableListOf()
        for (merknad in poengrekke.merknadListe) {
            merknadListe.add(Merknad(merknad))
        }
    }
}