package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.InntektsavkortingTypeCti;

import java.io.Serializable;

/**
 * Inneholder felles felt for avkorting av b�de UT og BT. Enkelte felt fra tidligere klasse Avkortningsinformasjon.
 */
public abstract class AbstraktAvkortingsinformasjon implements Serializable {


    /**
     * Antall m�neder f�r virk.
     */
    private int antallMndFor;

    /**
     * Antall m�neder fom virk.
     */
    private int antallMndEtter;

    /**
     * Inntekt over dette taket gir ingen ytelse.
     */
    private int inntektstak;

    /**
     * Beregnet avkortingsbel�p f�r justering for tidligere fradrag per �r.
     */
    private int avkortingsbelopPerAr;

    /**
     * Angir den netto ytelse som gjenst�r � utbetale for �ret
     */
    private int restTilUtbetaling;

    /**
     * Angir om inntektsavkorting er gjort med hensyn til etteroppgj�r, evt ved revurdering.
     */
    private InntektsavkortingTypeCti inntektsavkortingType;

}
