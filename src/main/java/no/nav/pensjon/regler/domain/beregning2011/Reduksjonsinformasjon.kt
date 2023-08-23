package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.kode.BarnetilleggRegelverkCti
import java.io.Serializable

/**
 * @author Lars Hartvigsen PK-20946
 */
class Reduksjonsinformasjon : Serializable {
    /**
     * Antall prosent brutto totalytelse ved 100% Uføregrad utgjør av OIFU. Ytelse inkluderer ordinår
     * uføretrygd, barnetillegg og et eventuelt gjenlevendetillegg.
     */
    var andelYtelseAvOIFU = 0.0

    /**
     * Beskriver hvilket regelverk som er benyttet i beregning av regelverk, se kodeverk K_BT_REGELVERK
     */
    var barnetilleggRegelverkType: BarnetilleggRegelverkCti? = null

    /**
     * Barnetillegg fellesbarn brutto per år
     */
    var btFBEtterReduksjon = 0

    /**
     * Barnetillegg særkullsbarn per år
     */
    var btSBEtterReduksjon = 0

    /**
     * 95% av oppjustert IFU (tak)
     */
    var gradertOppjustertIFU = 0

    /**
     * Samlet brutto etter reduksjon for barnetillegg særkullsbarn/fellesbarn
     */
    var sumBruttoEtterReduksjonBT = 0

    /**
     * Samlet brutto før reduksjon for barnetillegg særkullsbarn/fellesbarn
     */
    var sumBruttoForReduksjonBT = 0

    /**
     * Sum av uføretrygd, gjenlevendetillegg og barnetillegg
     */
    var sumUTBT = 0

    /**
     * Antall felles- og særkullsbarn
     */
    var totaltAntallBarn = 0

    /**
     * Angir prosentsatsen som brukes til å beregne taket for hvor stor samlet ugradert uføretrygd og brutto barnetillegg brukeren kan ha i forhold til oppjustert IFU før brutto
     * barnetillegg blir redusert
     */
    var prosentsatsOIFUForTak = 0

}