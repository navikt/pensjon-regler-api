package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.BarnetilleggRegelverkCti;

import java.io.Serializable;

/**
 * @author Lars Hartvigsen PK-20946
 */
public class Reduksjonsinformasjon implements Serializable {


    /**
     * Antall prosent brutto totalytelse ved 100% uf�regrad utgj�r av OIFU. Ytelse inkluderer ordin�r
     * uf�retrygd, barnetillegg og et eventuelt gjenlevendetillegg.
     */
    private double andelYtelseAvOIFU;

    /**
     * Beskriver hvilket regelverk som er benyttet i beregning av regelverk, se kodeverk K_BT_REGELVERK
     */
    private BarnetilleggRegelverkCti barnetilleggRegelverkType;

    /**
     * Barnetillegg fellesbarn brutto per �r
     */
    private int btFBEtterReduksjon;

    /**
     * Barnetillegg s�rkullsbarn per �r
     */
    private int btSBEtterReduksjon;

    /**
     * 95% av oppjustert IFU (tak)
     */
    private int gradertOppjustertIFU;

    /**
     * Samlet brutto etter reduksjon for barnetillegg s�rkullsbarn/fellesbarn
     */
    private int sumBruttoEtterReduksjonBT;

    /**
     * Samlet brutto f�r reduksjon for barnetillegg s�rkullsbarn/fellesbarn
     */
    private int sumBruttoForReduksjonBT;

    /**
     * Sum av uf�retrygd, gjenlevendetillegg og barnetillegg
     */
    private int sumUTBT;

    /**
     * Antall felles- og s�rkullsbarn
     */
    private int totaltAntallBarn;

    /**
     * Angir prosentsatsen som brukes til � beregne taket for hvor stor samlet ugradert uf�retrygd og brutto barnetillegg brukeren kan ha i forhold til oppjustert IFU f�r brutto
     * barnetillegg blir redusert
     */
    private int prosentsatsOIFUForTak;

}
