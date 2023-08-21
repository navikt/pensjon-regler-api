package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.GuiPrompt;
import no.nav.pensjon.regler.domain.kode.FormelKodeCti;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

import java.io.Serializable;

public class BarnetilleggFellesbarnUT extends AbstraktBarnetilleggUT implements Serializable {

    private static final long serialVersionUID = -8872689553836646951L;

    /**
     * Beløp som er fratrukket annen forelders inntekt (inntil 1G)
     */
    @GuiPrompt(prompt = "Beløp fratrukket annen forelders inntekt (inntil 1G)")
    private int belopFratrukketAnnenForeldersInntekt;

    /**
     * Brukers inntekt
     */
    @GuiPrompt(prompt = "Brukers inntekt")
    private int brukersInntektTilAvkortning;

    /**
     * Annen forelders inntekt brukt i behovsprøving
     */
    @GuiPrompt(prompt = "Annen forelders inntekt")
    private int inntektAnnenForelder;
	
	/**
     * Annen forelders uføretrygd før justering.
     */
	 @GuiPrompt(prompt = "Annen forelders uføretrygd før justering")
    private int annenForelderUforetrygdForJustering;

    public BarnetilleggFellesbarnUT() {
        super();
        setFormelKode(new FormelKodeCti("BTx"));
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_TFB");
    }

    public BarnetilleggFellesbarnUT(BarnetilleggFellesbarnUT barnetilleggFellesbarnUT) {
        super(barnetilleggFellesbarnUT);
        belopFratrukketAnnenForeldersInntekt = barnetilleggFellesbarnUT.belopFratrukketAnnenForeldersInntekt;
        brukersInntektTilAvkortning = barnetilleggFellesbarnUT.brukersInntektTilAvkortning;
        inntektAnnenForelder = barnetilleggFellesbarnUT.inntektAnnenForelder;
		annenForelderUforetrygdForJustering = barnetilleggFellesbarnUT.annenForelderUforetrygdForJustering;
    }

    public int getBelopFratrukketAnnenForeldersInntekt() {
        return belopFratrukketAnnenForeldersInntekt;
    }

    public int getBrukersInntektTilAvkortning() {
        return brukersInntektTilAvkortning;
    }

    public int getInntektAnnenForelder() {
        return inntektAnnenForelder;
    }
	
    public int getAnnenForelderUforetrygdForJustering() {
        return annenForelderUforetrygdForJustering;
    }

    public void setBelopFratrukketAnnenForeldersInntekt(int belopFratrukketAnnenForeldersInntekt) {
        this.belopFratrukketAnnenForeldersInntekt = belopFratrukketAnnenForeldersInntekt;
    }

    public void setBrukersInntektTilAvkortning(int brukersInntektTilAvkortning) {
        this.brukersInntektTilAvkortning = brukersInntektTilAvkortning;
    }

    public void setInntektAnnenForelder(int inntektAnnenForelder) {
        this.inntektAnnenForelder = inntektAnnenForelder;
    }
	
	 public void setAnnenForelderUforetrygdForJustering(int annenForelderUforetrygdForJustering) {
        this.annenForelderUforetrygdForJustering = annenForelderUforetrygdForJustering;
    }

}
