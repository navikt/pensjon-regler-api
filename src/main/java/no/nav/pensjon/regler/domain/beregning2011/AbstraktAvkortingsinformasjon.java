package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.kode.InntektsavkortingTypeCti;

import java.io.Serializable;

/**
 * Inneholder felles felt for avkorting av b�de UT og BT. Enkelte felt fra tidligere klasse Avkortningsinformasjon.
 */
public abstract class AbstraktAvkortingsinformasjon implements Serializable {

    private static final long serialVersionUID = 250487178560129999L;

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

    public AbstraktAvkortingsinformasjon() {
    }
    
    /**
     * Copy-constructor
     */
    public AbstraktAvkortingsinformasjon(AbstraktAvkortingsinformasjon abstraktAvkortingsinformasjon) {
        antallMndFor = abstraktAvkortingsinformasjon.antallMndFor;
        antallMndEtter = abstraktAvkortingsinformasjon.antallMndEtter;
        inntektstak = abstraktAvkortingsinformasjon.inntektstak;
        avkortingsbelopPerAr = abstraktAvkortingsinformasjon.avkortingsbelopPerAr;
        restTilUtbetaling = abstraktAvkortingsinformasjon.restTilUtbetaling;
        inntektsavkortingType = abstraktAvkortingsinformasjon.inntektsavkortingType;
        if (abstraktAvkortingsinformasjon.getInntektsavkortingType() != null) {
            setInntektsavkortingType(new InntektsavkortingTypeCti(abstraktAvkortingsinformasjon.getInntektsavkortingType()));
        }
    }
    
    public int getAntallMndFor() {
        return antallMndFor;
    }

    public void setAntallMndFor(int antallMndFor) {
        this.antallMndFor = antallMndFor;
    }

    public int getAntallMndEtter() {
        return antallMndEtter;
    }

    public void setAntallMndEtter(int antallMndEtter) {
        this.antallMndEtter = antallMndEtter;
    }

    public int getInntektstak() {
        return inntektstak;
    }

    public void setInntektstak(int inntektstak) {
        this.inntektstak = inntektstak;
    }

    public int getAvkortingsbelopPerAr() {
        return avkortingsbelopPerAr;
    }

    public void setAvkortingsbelopPerAr(int avkortingsbelopPerAr) {
        this.avkortingsbelopPerAr = avkortingsbelopPerAr;
    }

    public int getRestTilUtbetaling() {
        return restTilUtbetaling;
    }

    public void setRestTilUtbetaling(int restTilUtbetaling) {
        this.restTilUtbetaling = restTilUtbetaling;
    }

    public InntektsavkortingTypeCti getInntektsavkortingType() {
        return inntektsavkortingType;
    }

    public void setInntektsavkortingType(InntektsavkortingTypeCti inntektsavkortingType) {
        this.inntektsavkortingType = inntektsavkortingType;
    }
}
