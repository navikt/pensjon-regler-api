package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.BarnetilleggRegelverkCti;

import java.io.Serializable;

/**
 * @author Lars Hartvigsen PK-20946
 */
public class Reduksjonsinformasjon implements Serializable {


    /**
     * Antall prosent brutto totalytelse ved 100% uføregrad utgjør av OIFU. Ytelse inkluderer ordinær
     * uføretrygd, barnetillegg og et eventuelt gjenlevendetillegg.
     */
    private double andelYtelseAvOIFU;

    /**
     * Beskriver hvilket regelverk som er benyttet i beregning av regelverk, se kodeverk K_BT_REGELVERK
     */
    private BarnetilleggRegelverkCti barnetilleggRegelverkType;

    /**
     * Barnetillegg fellesbarn brutto per år
     */
    private int btFBEtterReduksjon;

    /**
     * Barnetillegg særkullsbarn per år
     */
    private int btSBEtterReduksjon;

    /**
     * 95% av oppjustert IFU (tak)
     */
    private int gradertOppjustertIFU;

    /**
     * Samlet brutto etter reduksjon for barnetillegg særkullsbarn/fellesbarn
     */
    private int sumBruttoEtterReduksjonBT;

    /**
     * Samlet brutto før reduksjon for barnetillegg særkullsbarn/fellesbarn
     */
    private int sumBruttoForReduksjonBT;

    /**
     * Sum av uføretrygd, gjenlevendetillegg og barnetillegg
     */
    private int sumUTBT;

    /**
     * Antall felles- og særkullsbarn
     */
    private int totaltAntallBarn;

    /**
     * Angir prosentsatsen som brukes til å beregne taket for hvor stor samlet ugradert uføretrygd og brutto barnetillegg brukeren kan ha i forhold til oppjustert IFU før brutto
     * barnetillegg blir redusert
     */
    private int prosentsatsOIFUForTak;

}
