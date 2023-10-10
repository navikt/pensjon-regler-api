package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.kode.EtteroppgjorResultatCti
import java.io.Serializable

class EtteroppgjorResultat : Serializable {
    /**
     * Totalbeløp for ytelsene uføretrygd og gjenlevendetillegg basert på tidligere vedtak, som var gjeldende (løpende eller i iverksettelsesløpet) i etteroppgjørsåret ved
     * beregning
     */
    var tidligereBelopUT = 0

    /**
     * Totalbeløp for ytelsen barnetillegg fellesbarn basert på tidligere vedtak, som var gjeldende (løpende eller i iverksettelsesløpet) i etteroppgjørsåret ved beregning
     */
    var tidligereBelopTFB = 0

    /**
     * Totalbeløp for ytelsen barnetillegg særkullsbarn basert på tidligere vedtak, som var gjeldende (løpende eller i iverksettelsesløpet) i etteroppgjørsåret ved beregning
     */
    var tidligereBelopTSB = 0

    /**
     * Totalbeløp for delytelsene uføretrygd, gjenlevendetillegg, barnetillegg særkullsbarn og barnetillegg fellesbarn (sum av tidligereBelopUT, tidligereBelopTFB,
     * tidligereBelopTSB)
     */
    var tidligereBelop = 0

    /**
     * Total beregnet uføretrygd og gjenlevendetillegg i etteroppgjørsåret
     */
    var totalBelopUT = 0

    /**
     * Totalt beregnet barnetillegg fellesbarn i etteroppgjørsåret
     */
    var totalBelopTFB = 0

    /**
     * Totalt beregnet barnetillegg særkullsbarn i etteroppgjørsåret
     */
    var totalBelopTSB = 0

    /**
     * Totalt beregnet uføretrygd, gjenlevendetillegg, barnetillegg særkullsbarn og barnetillegg fellesbarn i etteroppgjørsåret (sum av totalBelopUT, totalBelopTFB, totalBelopTSB)
     */
    var totalBelop = 0

    /**
     * Angir kronebeløp for et helt rettsgebyr
     */
    var rettsgebyr = 0

    /**
     * Resultatet av etteroppgjøret.
     */
    var etteroppgjorResultatType: EtteroppgjorResultatCti? = null

    /**
     * Toleransegrense for etterbetaling.
     */
    var toleransegrensePositiv = 0

    /**
     * Toleransegrense for tilbakekreving.
     */
    var toleransegrenseNegativ = 0

    /**
     * Representerer inntekten som legges til grunn for beregningen av etteroppgjøret for uføretrygden.
     */
    var inntektUT = 0

    /**
     * Inntekten som legges til grunn for beregningen av etteroppgjøret for barnetillegget for fellesbarn
     */
    var inntektTFB = 0

    /**
     * Inntekten som legges til grunn for beregningen av etteroppgjøret for barnetillegget for særkullsbarn
     */
    var inntektTSB = 0

    /**
     * Det totale avviksbeløpet i UT, TFB og TSB.
     */
    var avviksbelop = 0

    /**
     * beløpet som utgjør differansen mellom uføretrygd og ev. gjenlevendetillegg basert på forventet og uføretrygd og ev. gjenlevendetillegg basert på lignet inntekt.
     */
    var avviksbelopUT = 0

    /**
     * beløpet som utgjør differansen mellom barnetillegget for fellesbarn basert på forventet og barnetillegget for fellesbarn basert på lignet inntekt
     */
    var avviksbelopTFB = 0

    /**
     * beløpet som utgjør differansen mellom barnetillegget for særkullsbarn basert på forventet og barnetillegget for særkullsbarn basert på lignet inntekt
     */
    var avviksbelopTSB = 0
}