package no.nav.domain.pensjon.regler.beregning2011;

import java.io.Serializable;

public abstract class AbstraktBarnetilleggUT extends AbstraktBarnetillegg implements Serializable {



    /**
     * Detaljer rundt avkortning av netto barnetillegg.
     */
    private AvkortingsinformasjonBT avkortingsinformasjon;

    /**
     * Inntektsavkortningsbeløp per år, før justering med differansebeløp
     */
    protected int avkortningsbelopPerAr;

    /**
     * Inntekt som fører til at barnetillegget ikke blir utbetalt
     */
    private int inntektstak;

    /**
     * Akkumulert netto hittil i året eksklusiv måned for beregningsperiodens fomDato.
     */
    protected int nettoAkk;

    /**
     * Gjenstående beløp brukeren har rett på for året som beregningsperioden starter, og inkluderer måneden det beregnes fra.
     */
    protected int nettoRestAr;

    /**
     * Uttrykker avviket mellom ytelseskomponenten basert på løpende inntektsavkorting og ytelseskomponenten basert på lignet inntekt.
     */
    private double periodisertAvvikEtteroppgjor;

    /**
     * Detaljer rundt reduksjon av brutto barnetillegg.
     */
    private Reduksjonsinformasjon reduksjonsinformasjon;

    /**
     * Årsbeløp for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    private int tidligereBelopAr;
	
	/**
     * Brukers uføretrygd før justering
     */
	 private int brukersUforetrygdForJustering;

}
