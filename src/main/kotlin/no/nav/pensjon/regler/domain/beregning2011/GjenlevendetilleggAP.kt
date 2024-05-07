package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.GjenlevendetilleggAPkap20Enum
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import no.nav.pensjon.regler.domain.util.formula.Formel
import no.nav.pensjon.regler.domain.util.formula.IFormelProvider

/**
 * GjenlevendetilleggAP
 */
class GjenlevendetilleggAP : Ytelseskomponent(), IFormelProvider {
    /**
     * Sum av GP, TP og PenT for AP2011 medregnet GJR.
     */
    var apKap19MedGJR = 0

    /**
     * Sum av GP, TP og PenT for AP2011 uten GJR.
     */
    var apKap19UtenGJR = 0

    /**
     * Differanse mellom AP med og uten GJR, justert til 100% uttaksgrad.
     */
    var referansebelop: Int = 0

    /**
     * Summen av reguleringsbeløp som har gått i fradrag på gjenlevendetillegget
     */
    var sumReguleringsfradrag : Int = 0

    /**
     * Det maksimale uttaksgrad som kan benyttes ved beregning av gjenlevendetillegget.
     */
    var anvendtUttaksgrad : Int = 100

    /**
     * Den beregningstekniske metoden som er benyttet for å fastsette gjenlevendetillegget.
     */
    var metode: GjenlevendetilleggAPkap20Enum = GjenlevendetilleggAPkap20Enum.INGEN

    /**
     * Map av formler brukt i beregning av ytelseskomponenten.
     */
    override var formelMap: HashMap<String, Formel> = HashMap()

    override val formelPrefix: String
        get() = "GJT_Kap20"

    override var ytelsekomponentType: YtelsekomponentTypeCti = YtelsekomponentTypeCti("AP_GJT")
}