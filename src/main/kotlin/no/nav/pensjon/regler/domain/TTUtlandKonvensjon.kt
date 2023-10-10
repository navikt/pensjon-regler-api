package no.nav.pensjon.regler.domain

import java.io.Serializable

/**
 * Trygdetid for utenlandssaker, men ikke EØS. Dvs nordisk konvensjon (artikkel
 * 10) og andre land med bilaterale avtaler.
 */
class TTUtlandKonvensjon : Serializable {
    /**
     * Brutto framtidig trygdetid i antall måneder etter Nordisk konvensjon.
     */
    var ftt_A10_brutto = 0

    /**
     * Netto framtidig trygdetid i antall måneder etter Nordisk konvensjon.
     */
    var ftt_A10_netto = 0

    /**
     * Om framtidig trygdetid etter Nordisk konvensjon er redusert etter
     * 4/5-dels regel.
     */
    var ftt_A10_redusert = false

    /**
     * Antall framtidige år, brukes ved bilaterale avtaler med UK og Nederland
     */
    var ft_ar = 0

    /**
     * Faktisk trygdetid i antall måneder etter Nordisk konvensjon.
     */
    var tt_A10_fa_mnd = 0

    /**
     * Faktisk trygdetid i antall år etter Nordisk konvensjon.
     */
    var tt_A10_anv_aar = 0

    /**
     * Teller i Nordisk pro-rata brøk.
     */
    var tt_A10_teller = 0

    /**
     * Nevner i Nordisk pro-rata brøk.
     */
    var tt_A10_nevner = 0

    /**
     * Trygdetiden settes lik antall år som blir tastet inn i feltet.
     */
    var tt_konvensjon_ar = 0

    /**
     * Trygdetid skal være like antall poeng år. Har bare betydning for personer
     * som har vært bosatt i utlandet.
     */
    var tt_lik_pa = false

    /**
     * Liste av merknader.
     */
    var merknadListe: List<Merknad> = mutableListOf()
}