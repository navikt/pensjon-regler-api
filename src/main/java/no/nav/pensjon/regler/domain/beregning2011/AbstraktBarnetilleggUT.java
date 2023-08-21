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
     * Inntektsavkortningsbeløp per år, før justering med differansebeløp
     */
    @GuiPrompt(prompt = "Inntektsavkortningsbeløp per år")
    protected int avkortningsbelopPerAr;

    /**
     * Inntekt som fører til at barnetillegget ikke blir utbetalt
     */
    @GuiPrompt(prompt = "Inntektstak")
    private int inntektstak;

    /**
     * Akkumulert netto hittil i året eksklusiv måned for beregningsperiodens fomDato.
     */
    @GuiPrompt(prompt = "Akkumulert netto")
    protected int nettoAkk;

    /**
     * Gjenstående beløp brukeren har rett på for året som beregningsperioden starter, og inkluderer måneden det beregnes fra.
     */
    @GuiPrompt(prompt = "Netto gjenstående beløp for året")
    protected int nettoRestAr;

    /**
     * Uttrykker avviket mellom ytelseskomponenten basert på løpende inntektsavkorting og ytelseskomponenten basert på lignet inntekt.
     */
    @GuiPrompt(prompt = "Periodisert avvik ved etteroppgjør")
    private double periodisertAvvikEtteroppgjor;

    /**
     * Detaljer rundt reduksjon av brutto barnetillegg.
     */
    @GuiPrompt(prompt = "Reduksjonsinformasjon")
    private Reduksjonsinformasjon reduksjonsinformasjon;

    /**
     * Årsbeløp for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    private int tidligereBelopAr;
	
	/**
     * Brukers uføretrygd før justering
     */
	 @GuiPrompt(prompt = "Brukers uføretrygd")
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
