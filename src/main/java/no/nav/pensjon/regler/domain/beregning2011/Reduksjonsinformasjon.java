package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.GuiPrompt;
import no.nav.pensjon.regler.domain.kode.BarnetilleggRegelverkCti;

import java.io.Serializable;

/**
 * @author Lars Hartvigsen PK-20946
 */
public class Reduksjonsinformasjon implements Serializable {

    private static final long serialVersionUID = -1581147705764692L;

    /**
     * Antall prosent brutto totalytelse ved 100% uføregrad utgjør av OIFU. Ytelse inkluderer ordinær
     * uføretrygd, barnetillegg og et eventuelt gjenlevendetillegg.
     */
    @GuiPrompt(prompt = "Antall prosent brutto totalytelse ved 100% uføregrad utgjør av OIFU")
    private double andelYtelseAvOIFU;

    /**
     * Beskriver hvilket regelverk som er benyttet i beregning av regelverk, se kodeverk K_BT_REGELVERK
     */
    @GuiPrompt(prompt = "Regelverk benyttet i beregning av barnetillegg")
    private BarnetilleggRegelverkCti barnetilleggRegelverkType;

    /**
     * Barnetillegg fellesbarn brutto per år
     */
    @GuiPrompt(prompt = " Barnetillegg fellesbarn brutto per år")
    private int btFBEtterReduksjon;

    /**
     * Barnetillegg særkullsbarn per år
     */
    @GuiPrompt(prompt = "Barnetillegg særkullsbarn per år")
    private int btSBEtterReduksjon;

    /**
     * 95% av oppjustert IFU (tak)
     */
    @GuiPrompt(prompt = "95% av oppjustert IFU (tak)")
    private int gradertOppjustertIFU;

    /**
     * Samlet brutto etter reduksjon for barnetillegg særkullsbarn/fellesbarn
     */
    @GuiPrompt(prompt = " Samlet brutto etter reduksjon for barnetillegg")
    private int sumBruttoEtterReduksjonBT;

    /**
     * Samlet brutto før reduksjon for barnetillegg særkullsbarn/fellesbarn
     */
    @GuiPrompt(prompt = "Samlet brutto før reduksjon for barnetillegg")
    private int sumBruttoForReduksjonBT;

    /**
     * Sum av uføretrygd, gjenlevendetillegg og barnetillegg
     */
    @GuiPrompt(prompt = "Sum av uføretrygd, gjenlevendetillegg og barnetillegg")
    private int sumUTBT;

    /**
     * Antall felles- og særkullsbarn
     */
    @GuiPrompt(prompt = "Antall felles- og særkullsbarn")
    private int totaltAntallBarn;

    /**
     * Angir prosentsatsen som brukes til å beregne taket for hvor stor samlet ugradert uføretrygd og brutto barnetillegg brukeren kan ha i forhold til oppjustert IFU før brutto
     * barnetillegg blir redusert
     */
    @GuiPrompt(prompt = "Prosentsats oppjustert IFU for tak")
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
