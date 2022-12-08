package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.FormelKodeCti;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

import java.io.Serializable;

public class BarnetilleggFellesbarnUT extends AbstraktBarnetilleggUT implements Serializable {

    /**
     * Beløp som er fratrukket annen forelders inntekt (inntil 1G)
     */
    private int belopFratrukketAnnenForeldersInntekt;

    /**
     * Brukers inntekt
     */
    private int brukersInntektTilAvkortning;

    /**
     * Annen forelders inntekt brukt i behovsprøving
     */
    private int inntektAnnenForelder;
	
	/**
     * Annen forelders uføretrygd før justering.
     */
	 private int annenForelderUforetrygdForJustering;

    public BarnetilleggFellesbarnUT() {
        super();
        setFormelKode(new FormelKodeCti("BTx"));
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_TFB");
    }

}
