package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.trygdetid.Brok;

import java.io.Serializable;
import java.util.Date;

public abstract class AbstraktBarnetilleggperiode implements Serializable{

    /**
     * Start for periode med et antall barn.
     */
    private Date fomDato;

    /**
     * Stopp for periode med et antall barn.
     */
    private Date tomDato;

    /**
     * Periodens lengde i antall m�neder.
     */
    private int lengde;

    /**
     * Antall barn det beregnes barnetillegg for i perioden.
     */
    private int antallBarn;

    /**
     * Fribel�pet for antall barn i perioden.
     */
    private int fribelop;

    /**
     * Brutto �rlig barnetillegg, beregnet for antall barn (felles- og s�rkullsbarn) i perioden og eventuelt redusert mot tak.
     */
    private int bruttoPerAr;

    /**
     * Reguleringsfaktor dersom perioden gjelder for en annen G enn GvedVirk.
     */
    private Brok reguleringsfaktor;

    /**
     * Halvparten av inntekt overskytende fribel�p. Fastsatt som �rlig bel�p, dvs oppjustert til �rlig bel�p dersom fribel�p og inntekt er periodisert.
     */
    private int avkortingsbelopPerAr;

}
