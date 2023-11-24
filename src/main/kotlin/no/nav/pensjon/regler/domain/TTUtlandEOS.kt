package no.nav.pensjon.regler.domain

import java.io.Serializable

/**
 * Trygdetid for EØS-tilfeller.
 */
class TTUtlandEOS : Serializable {
    /**
     * Framtidig trygdetid EØS i antall måneder.
     */
    var ftt_eos = 0

    /**
     * Om framtidig trygdetid EØS er redusert. Dersom faktisk trygdetid
     * medregnet tid i Norge og EØS er mindre enn 4/5 av opptjeningstiden skal
     * framtidig trygdetid for EØS beregnes med reduksjon.
     */
    var ftt_eos_redusert = false

    /**
     * Teoretisk trygdetid EØS i antall måneder.
     */
    var tt_eos_anv_mnd = 0

    /**
     * Teoretisk trygdetid EØS i antall år.
     */
    var tt_eos_anv_ar = 0

    /**
     * Pro-rata trygdetid i EØS land utenfor Norge i antall måneder.
     */
    var tt_eos_pro_rata_mnd = 0

    /**
     * Teoretisk trygdetid i EØS land utenfor Norge i antall måneder.
     */
    var tt_eos_teoretisk_mnd = 0

    /**
     * Teller i EØS pro-rata brøk, i antall måneder.
     */
    var tt_eos_teller = 0

    /**
     * Nevner i EØS pro-rata brøk, i antall måneder.
     */
    var tt_eos_nevner = 0
    // usikker på om disse skal ligge begge steder
    /**
     * Trygdetid skal være lik antall poengår. Har bare betydning for personer
     * som har vært bosatt i utlandet.
     */
    var tt_lik_pa = false

    /**
     * Trygdetiden settes lik antall år som blir tastet inn i feltet.
     */
    var tt_konvensjon_ar = 0

    /**
     * Liste av merknader.
     */
    var merknadListe: MutableList<Merknad> = mutableListOf()
}