package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.InntektsavkortingTypeCti;

import java.io.Serializable;

/**
 * Inneholder felles felt for avkorting av både UT og BT. Enkelte felt fra tidligere klasse Avkortningsinformasjon.
 */
public abstract class AbstraktAvkortingsinformasjon implements Serializable {


    /**
     * Antall måneder før virk.
     */
    private int antallMndFor;

    /**
     * Antall måneder fom virk.
     */
    private int antallMndEtter;

    /**
     * Inntekt over dette taket gir ingen ytelse.
     */
    private int inntektstak;

    /**
     * Beregnet avkortingsbeløp før justering for tidligere fradrag per år.
     */
    private int avkortingsbelopPerAr;

    /**
     * Angir den netto ytelse som gjenstår å utbetale for året
     */
    private int restTilUtbetaling;

    /**
     * Angir om inntektsavkorting er gjort med hensyn til etteroppgjør, evt ved revurdering.
     */
    private InntektsavkortingTypeCti inntektsavkortingType;

}
