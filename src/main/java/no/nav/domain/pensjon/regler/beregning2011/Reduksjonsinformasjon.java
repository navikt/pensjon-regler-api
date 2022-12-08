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

    public Reduksjonsinformasjon() {
        super();
    }

    public Reduksjonsinformasjon(Reduksjonsinformasjon rg) {
        super();
        this.sumUTBT = rg.sumUTBT;
        this.gradertOppjustertIFU = rg.gradertOppjustertIFU;
        this.totaltAntallBarn = rg.totaltAntallBarn;
        this.sumBruttoForReduksjonBT = rg.sumBruttoForReduksjonBT;
        this.sumBruttoEtterReduksjonBT = rg.sumBruttoEtterReduksjonBT;
        this.btFBEtterReduksjon = rg.btFBEtterReduksjon;
        this.btSBEtterReduksjon = rg.btSBEtterReduksjon;
        this.prosentsatsOIFUForTak = rg.prosentsatsOIFUForTak;
        if (rg.barnetilleggRegelverkType != null) {
            this.barnetilleggRegelverkType = new BarnetilleggRegelverkCti(rg.barnetilleggRegelverkType);
        }
        this.andelYtelseAvOIFU = rg.andelYtelseAvOIFU;
    }

    public double getAndelYtelseAvOIFU() {
        return andelYtelseAvOIFU;
    }

    public BarnetilleggRegelverkCti getBarnetilleggRegelverkType() {
        return barnetilleggRegelverkType;
    }

    public int getBtFBEtterReduksjon() {
        return btFBEtterReduksjon;
    }

    public int getBtSBEtterReduksjon() {
        return btSBEtterReduksjon;
    }

    public int getGradertOppjustertIFU() {
        return gradertOppjustertIFU;
    }

    public int getSumBruttoEtterReduksjonBT() {
        return sumBruttoEtterReduksjonBT;
    }

    public int getSumBruttoForReduksjonBT() {
        return sumBruttoForReduksjonBT;
    }

    public int getSumUTBT() {
        return sumUTBT;
    }

    public int getTotaltAntallBarn() {
        return totaltAntallBarn;
    }

    public void setAndelYtelseAvOIFU(double andelYtelseAvOIFU) {
        this.andelYtelseAvOIFU = andelYtelseAvOIFU;
    }

    public int getProsentsatsOIFUForTak() {
        return prosentsatsOIFUForTak;
    }
    
    public void setBarnetilleggRegelverkType(BarnetilleggRegelverkCti barnetilleggRegelverkType) {
        this.barnetilleggRegelverkType = barnetilleggRegelverkType;
    }

    public void setBtFBEtterReduksjon(int btFBEtterReduksjon) {
        this.btFBEtterReduksjon = btFBEtterReduksjon;
    }

    public void setBtSBEtterReduksjon(int btSBEtterReduksjon) {
        this.btSBEtterReduksjon = btSBEtterReduksjon;
    }

    public void setGradertOppjustertIFU(int gradertOppjustertIFU) {
        this.gradertOppjustertIFU = gradertOppjustertIFU;
    }

    public void setSumBruttoEtterReduksjonBT(int sumBruttoEtterReduksjonBT) {
        this.sumBruttoEtterReduksjonBT = sumBruttoEtterReduksjonBT;
    }

    public void setSumBruttoForReduksjonBT(int sumBruttoForReduksjonBT) {
        this.sumBruttoForReduksjonBT = sumBruttoForReduksjonBT;
    }

    public void setSumUTBT(int sumUTBT) {
        this.sumUTBT = sumUTBT;
    }

    public void setTotaltAntallBarn(int totaltAntallBarn) {
        this.totaltAntallBarn = totaltAntallBarn;
    }

    public void setProsentsatsOIFUForTak(int prosentsatsOIFUForTak) {
        this.prosentsatsOIFUForTak = prosentsatsOIFUForTak;
    }
}
