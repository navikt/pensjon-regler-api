package no.nav.pensjon.regler.domain.beregning2011;

import java.io.Serializable;

public class BeregningsInformasjonMinstenivatilleggPensjonistpar implements Serializable {
    private static final long serialVersionUID = 2621509387713339525L;

    /*
     * Beregnet pensjon pensjon
     */
    private double samletPensjon;
    /*
     * Minstepensjonsniva sats
     */
    private double mpnSatsOrdinaer;
    /*
     * Garantipensjonpensjonsniva sats
     */
    private double garPNSatsOrdinaer;
    /*
     * saertillegg sats
     */
    private double stSatsOrdinaer;
    /*
     * tt anvendt brukt i alderspensjon etter kapittel 19
     */
    private int tt_anv_AP;
    /*
     * tt anvendt brukt i alderspensjon etter kapittel 20
     */
    private int tt_anv_AP_Kapittel20;

    /*
     * tt anvendt brukt i uforepensjon
     */
    private int tt_anv_UP;
    /*
     * trygdetid i prorata beregning
     */
    private double prorataUP;
    /*
     * teller for proratabrok
     */
    private int prorataUPTeller;
    /*
     * nevner for proratabrok
     */
    private int prorataUPNevner;
    /*
     * personens gjeldende uttaksgrad
     */
    private int uttaksgrad;
    /*
     * personens gjeldende uforegrad
     */
    private int uforegrad;

    public BeregningsInformasjonMinstenivatilleggPensjonistpar() {
        super();
    }

    /**
     * Copy constructor
     */
    public BeregningsInformasjonMinstenivatilleggPensjonistpar(BeregningsInformasjonMinstenivatilleggPensjonistpar beregningsInformasjonMinstenivatilleggPensjonistpar) {
        samletPensjon = beregningsInformasjonMinstenivatilleggPensjonistpar.samletPensjon;
        mpnSatsOrdinaer = beregningsInformasjonMinstenivatilleggPensjonistpar.mpnSatsOrdinaer;
        stSatsOrdinaer = beregningsInformasjonMinstenivatilleggPensjonistpar.stSatsOrdinaer;
        garPNSatsOrdinaer = beregningsInformasjonMinstenivatilleggPensjonistpar.garPNSatsOrdinaer;
        tt_anv_AP = beregningsInformasjonMinstenivatilleggPensjonistpar.tt_anv_AP;
        tt_anv_AP_Kapittel20 = beregningsInformasjonMinstenivatilleggPensjonistpar.tt_anv_AP_Kapittel20;
        tt_anv_UP = beregningsInformasjonMinstenivatilleggPensjonistpar.tt_anv_UP;
        prorataUP = beregningsInformasjonMinstenivatilleggPensjonistpar.prorataUP;
        prorataUPNevner = beregningsInformasjonMinstenivatilleggPensjonistpar.prorataUPNevner;
        prorataUPTeller = beregningsInformasjonMinstenivatilleggPensjonistpar.prorataUPTeller;
        uttaksgrad = beregningsInformasjonMinstenivatilleggPensjonistpar.uttaksgrad;
        uforegrad = beregningsInformasjonMinstenivatilleggPensjonistpar.uforegrad;
    }

    public double getMpnSatsOrdinaer() {
        return mpnSatsOrdinaer;
    }

    public void setMpnSatsOrdinaer(double mpnSatsOrdinaer) {
        this.mpnSatsOrdinaer = mpnSatsOrdinaer;
    }

    public double getProrataUP() {
        return prorataUP;
    }

    public void setProrataUP(double prorataUP) {
        this.prorataUP = prorataUP;
    }

    public int getProrataUPNevner() {
        return prorataUPNevner;
    }

    public void setProrataUPNevner(int prorataUPNevner) {
        this.prorataUPNevner = prorataUPNevner;
    }

    public int getProrataUPTeller() {
        return prorataUPTeller;
    }

    public void setProrataUPTeller(int prorataUPTeller) {
        this.prorataUPTeller = prorataUPTeller;
    }

    public double getSamletPensjon() {
        return samletPensjon;
    }

    public void setSamletPensjon(double samletPensjon) {
        this.samletPensjon = samletPensjon;
    }

    public double getStSatsOrdinaer() {
        return stSatsOrdinaer;
    }

    public void setStSatsOrdinaer(double stSatsOrdinaer) {
        this.stSatsOrdinaer = stSatsOrdinaer;
    }

    public int getTt_anv_AP() {
        return tt_anv_AP;
    }

    public void setTt_anv_AP(int tt_anv_AP) {
        this.tt_anv_AP = tt_anv_AP;
    }

    public int getTt_anv_UP() {
        return tt_anv_UP;
    }

    public void setTt_anv_UP(int tt_anv_UP) {
        this.tt_anv_UP = tt_anv_UP;
    }

    public int getUforegrad() {
        return uforegrad;
    }

    public void setUforegrad(int uforegrad) {
        this.uforegrad = uforegrad;
    }

    public int getUttaksgrad() {
        return uttaksgrad;
    }

    public void setUttaksgrad(int uttaksgrad) {
        this.uttaksgrad = uttaksgrad;
    }

    public double getGarPNSatsOrdinaer() {
        return garPNSatsOrdinaer;
    }

    public void setGarPNSatsOrdinaer(double garPNSatsOrdinaer) {
        this.garPNSatsOrdinaer = garPNSatsOrdinaer;
    }

    public int getTt_anv_AP_Kapittel20() {
        return tt_anv_AP_Kapittel20;
    }

    public void setTt_anv_AP_Kapittel20(int tt_anv_AP_Kapittel20) {
        this.tt_anv_AP_Kapittel20 = tt_anv_AP_Kapittel20;
    }

}
