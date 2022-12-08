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
     * Periodens lengde i antall måneder.
     */
    private int lengde;

    /**
     * Antall barn det beregnes barnetillegg for i perioden.
     */
    private int antallBarn;

    /**
     * Fribeløpet for antall barn i perioden.
     */
    private int fribelop;

    /**
     * Brutto årlig barnetillegg, beregnet for antall barn (felles- og særkullsbarn) i perioden og eventuelt redusert mot tak.
     */
    private int bruttoPerAr;

    /**
     * Reguleringsfaktor dersom perioden gjelder for en annen G enn GvedVirk.
     */
    private Brok reguleringsfaktor;

    /**
     * Halvparten av inntekt overskytende fribeløp. Fastsatt som årlig beløp, dvs oppjustert til årlig beløp dersom fribeløp og inntekt er periodisert.
     */
    private int avkortingsbelopPerAr;

}
