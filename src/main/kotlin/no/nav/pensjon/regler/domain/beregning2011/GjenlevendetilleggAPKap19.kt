package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.GjenlevendetilleggAPkap19Enum
import no.nav.pensjon.regler.domain.enum.YtelseskomponentTypeEnum
import no.nav.pensjon.regler.domain.util.formula.Formel
import no.nav.pensjon.regler.domain.util.formula.IFormelProvider

class GjenlevendetilleggAPKap19 : Ytelseskomponent(), IFormelProvider {
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
    var referansebelop = 0

    /**
     * Den beregningstekniske metoden som er benyttet for å fastsette gjenlevendetillegget.
     */
    var metode: GjenlevendetilleggAPkap19Enum = GjenlevendetilleggAPkap19Enum.INGEN

    /**
     * Map av formler brukt i beregning av Tilleggspensjon.
     */
    override var formelMap: HashMap<String, Formel> = HashMap()

    override var ytelsekomponentTypeEnum: YtelseskomponentTypeEnum = YtelseskomponentTypeEnum.AP_GJT_KAP19
}