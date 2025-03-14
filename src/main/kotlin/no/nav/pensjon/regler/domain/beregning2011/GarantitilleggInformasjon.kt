package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.BorMedTypeEnum
import java.io.Serializable

class GarantitilleggInformasjon : Serializable {
    var anvendtSivilstandEnum: BorMedTypeEnum? = null
    var pensjonsbeholdningBelopVed67 = 0.0
    var garantipensjonsbeholdningBelopVed67 = 0.0
    var tt_kapittel20Ved67 = 0
    var tt_kapittel19Ved67 = 0
    var pa_f92Ved67 = 0
    var pa_e91Ved67 = 0
    var ftVed67 = 0.0
    var dtVed67 = 0.0
    var sptVed67 = 0.0
    var tt_2009 = 0
    var pa_f92_2009 = 0
    var pa_e91_2009 = 0
    var spt_2009 = 0.0
    var ft67_1962 = 0.0
    var dt67_1962 = 0.0

    /**
     * Indikerer om regeltjeneste har estimert trygdetid kapittel 19 basert på
     * trygdetidsgrunnlag for kapittel 20. Denne estimering gjøres i forbindelse med
     * beregning av garantitilleggsbeholdning BER3156. Ref. CR 216411.
     */
    var estimertTTkap19Benyttet = false

}