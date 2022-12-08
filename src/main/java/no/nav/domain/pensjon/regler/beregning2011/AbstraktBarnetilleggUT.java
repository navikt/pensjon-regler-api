package no.nav.domain.pensjon.regler.beregning2011;

import java.io.Serializable;

public abstract class AbstraktBarnetilleggUT extends AbstraktBarnetillegg implements Serializable {



    /**
     * Detaljer rundt avkortning av netto barnetillegg.
     */
    private AvkortingsinformasjonBT avkortingsinformasjon;

    /**
     * Inntektsavkortningsbel�p per �r, f�r justering med differansebel�p
     */
    protected int avkortningsbelopPerAr;

    /**
     * Inntekt som f�rer til at barnetillegget ikke blir utbetalt
     */
    private int inntektstak;

    /**
     * Akkumulert netto hittil i �ret eksklusiv m�ned for beregningsperiodens fomDato.
     */
    protected int nettoAkk;

    /**
     * Gjenst�ende bel�p brukeren har rett p� for �ret som beregningsperioden starter, og inkluderer m�neden det beregnes fra.
     */
    protected int nettoRestAr;

    /**
     * Uttrykker avviket mellom ytelseskomponenten basert p� l�pende inntektsavkorting og ytelseskomponenten basert p� lignet inntekt.
     */
    private double periodisertAvvikEtteroppgjor;

    /**
     * Detaljer rundt reduksjon av brutto barnetillegg.
     */
    private Reduksjonsinformasjon reduksjonsinformasjon;

    /**
     * �rsbel�p for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    private int tidligereBelopAr;
	
	/**
     * Brukers uf�retrygd f�r justering
     */
	 private int brukersUforetrygdForJustering;

}
