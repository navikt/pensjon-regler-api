package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import java.io.Serializable

/**
 * Objektet inneholder den faktiske pensjonen under utbetaling, samt en liste
 * over delytelsene som denne består av.
 */
class PensjonUnderUtbetaling : Serializable {
    /**
     * månedsbeløp netto, summen av alle delytelsene i ytelseskomponenter. Disse er
     * avrundet hver for seg til nårmeste krone. Dette medfører at
     * avrund(totalbelopNettoAr/12) vil kunne være forskjellig fra totalbelopNetto.
     */
    var totalbelopNetto = 0

    /**
     * årlig netto beløp under utbetaling
     */
    var totalbelopNettoAr = 0.0

    /**
     * Angir sum brutto per måned.
     */
    var totalbelopBrutto = 0

    /**
     * Angir sum brutto per år.
     */
    var totalbelopBruttoAr = 0.0

    /**
     * Indikerer hvilken beregningsformel som ble brukt.
     */
    var formelKodeEnum: FormelKodeEnum = FormelKodeEnum.BPUx

    var pubReguleringFratrekk = 0.0
    var ytelseskomponenter: MutableList<Ytelseskomponent> = mutableListOf()
}