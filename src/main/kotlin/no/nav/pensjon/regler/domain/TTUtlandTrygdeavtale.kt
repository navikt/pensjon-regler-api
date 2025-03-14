package no.nav.pensjon.regler.domain

import no.nav.pensjon.regler.domain.enum.AvtaleLandEnum
import no.nav.pensjon.regler.domain.grunnlag.AntallArMndDag
import java.io.Serializable

/**
 * Trygdetid for land med bilaterale avtaler.
 */
class TTUtlandTrygdeavtale : Serializable {
    /**
     * Framtidig trygdetid i avtaleland i antall måneder.
     */
    var ftt = 0

    /**
     * Om framtidig trygdetid er redusert etter 4/5-dels regel.
     */
    var ftt_redusert = false

    /**
     * Faktisk trygdetid i avtaleland i antall måneder.
     */
    var tt_fa_mnd = 0

    /**
     * Anvendt trygdetid i avtaleland i antall år.
     */
    var tt_anv_ar = 0

    /**
     * Anvendt trygdetid i avtaleland i antall måneder.
     */
    var tt_anv_mnd = 0

    /**
     * Teller i pro-rata brøk.
     */
    var pro_rata_teller = 0

    /**
     * Nevner i pro-rata brøk.
     */
    var pro_rata_nevner = 0

    /**
     * Avtaleland som trygdetid er opptjent i.
     */
    var avtalelandEnum: AvtaleLandEnum? = null

    /**
     * PL-7390: Støtte trygdeavtaler ifbm halvminsteytelse uføretrygd
     * Felt som blir brukt for å holde orden på nøyaktig antall år, måneder og dager trygdetid
     * for å unngå avrundingsfeil på grunn av dobbel avrunding.
     * Benyttes i sammenheng med halv minstepensjon/minsteytelse.
     */
    var tt_fa: AntallArMndDag = AntallArMndDag()

    /**
     * Liste av merknader.
     */
    var merknadListe: List<Merknad> = mutableListOf()
}