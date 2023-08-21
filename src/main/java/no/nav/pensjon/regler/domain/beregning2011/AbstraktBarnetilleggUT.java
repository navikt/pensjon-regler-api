package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.GuiPrompt;

import java.io.Serializable;

public abstract class AbstraktBarnetilleggUT extends AbstraktBarnetillegg implements Serializable, UforetrygdYtelseskomponent {

    private static final long serialVersionUID = -2193426680033145105L;

    /**
     * Detaljer rundt avkortning av netto barnetillegg.
     */
    @GuiPrompt(prompt = "Informasjon om avkorting av barnetillegg")
    private AvkortingsinformasjonBT avkortingsinformasjon;

    /**
     * Inntektsavkortningsbel�p per �r, f�r justering med differansebel�p
     */
    @GuiPrompt(prompt = "Inntektsavkortningsbel�p per �r")
    protected int avkortningsbelopPerAr;

    /**
     * Inntekt som f�rer til at barnetillegget ikke blir utbetalt
     */
    @GuiPrompt(prompt = "Inntektstak")
    private int inntektstak;

    /**
     * Akkumulert netto hittil i �ret eksklusiv m�ned for beregningsperiodens fomDato.
     */
    @GuiPrompt(prompt = "Akkumulert netto")
    protected int nettoAkk;

    /**
     * Gjenst�ende bel�p brukeren har rett p� for �ret som beregningsperioden starter, og inkluderer m�neden det beregnes fra.
     */
    @GuiPrompt(prompt = "Netto gjenst�ende bel�p for �ret")
    protected int nettoRestAr;

    /**
     * Uttrykker avviket mellom ytelseskomponenten basert p� l�pende inntektsavkorting og ytelseskomponenten basert p� lignet inntekt.
     */
    @GuiPrompt(prompt = "Periodisert avvik ved etteroppgj�r")
    private double periodisertAvvikEtteroppgjor;

    /**
     * Detaljer rundt reduksjon av brutto barnetillegg.
     */
    @GuiPrompt(prompt = "Reduksjonsinformasjon")
    private Reduksjonsinformasjon reduksjonsinformasjon;

    /**
     * �rsbel�p for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    private int tidligereBelopAr;
	
	/**
     * Brukers uf�retrygd f�r justering
     */
	 @GuiPrompt(prompt = "Brukers uf�retrygd")
    private int brukersUforetrygdForJustering;

    

    public AbstraktBarnetilleggUT() {
        super();
    }

    public AbstraktBarnetilleggUT(AbstraktBarnetilleggUT ab) {
        super(ab);
        inntektstak = ab.getInntektstak();
        nettoAkk = ab.nettoAkk;
        nettoRestAr = ab.nettoRestAr;
        reduksjonsinformasjon = ab.reduksjonsinformasjon;
        avkortingsinformasjon = ab.avkortingsinformasjon;
        periodisertAvvikEtteroppgjor = ab.periodisertAvvikEtteroppgjor;
        tidligereBelopAr = ab.tidligereBelopAr;
		brukersUforetrygdForJustering = ab.brukersUforetrygdForJustering;
      
    }

    public AvkortingsinformasjonBT getAvkortingsinformasjon() {
        return avkortingsinformasjon;
    }

    public int getAvkortningsbelopPerAr() {
        return avkortningsbelopPerAr;
    }

    public int getInntektstak() {
        return inntektstak;
    }

    public int getNettoAkk() {
        return nettoAkk;
    }

    public int getNettoRestAr() {
        return nettoRestAr;
    }

    public double getPeriodisertAvvikEtteroppgjor() {
        return periodisertAvvikEtteroppgjor;
    }

    public Reduksjonsinformasjon getReduksjonsinformasjon() {
        return reduksjonsinformasjon;
    }
    public int getBrukersUforetrygdForJustering() {
        return brukersUforetrygdForJustering;
    }

    public void setAvkortingsinformasjon(AvkortingsinformasjonBT avkortingsinformasjon) {
        this.avkortingsinformasjon = avkortingsinformasjon;
    }

    public void setAvkortningsbelopPerAr(int avkortningsbelopPerAr) {
        this.avkortningsbelopPerAr = avkortningsbelopPerAr;
    }

    public void setInntektstak(int inntektstak) {
        this.inntektstak = inntektstak;
    }

    public void setNettoAkk(int nettoAkk) {
        this.nettoAkk = nettoAkk;
    }

    public void setNettoRestAr(int nettoRestAr) {
        this.nettoRestAr = nettoRestAr;
    }

    public void setPeriodisertAvvikEtteroppgjor(double periodisertAvvikEtteroppgjor) {
        this.periodisertAvvikEtteroppgjor = periodisertAvvikEtteroppgjor;
    }

    public void setReduksjonsinformasjon(Reduksjonsinformasjon reduksjonsinformasjon) {
        this.reduksjonsinformasjon = reduksjonsinformasjon;
    }

    public void setBrukersUforetrygdForJustering(int brukersUforetrygdForJustering) {
        this.brukersUforetrygdForJustering = brukersUforetrygdForJustering;
    }

    @Override
    public int getTidligereBelopAr() {
        return tidligereBelopAr;
    }

    @Override
    public void setTidligereBelopAr(int tidligereBelopAr) {
        this.tidligereBelopAr = tidligereBelopAr;
    }
}
