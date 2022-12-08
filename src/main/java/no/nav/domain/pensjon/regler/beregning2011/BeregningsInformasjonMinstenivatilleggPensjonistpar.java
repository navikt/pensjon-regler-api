package no.nav.domain.pensjon.regler.beregning2011;

import java.io.Serializable;

public class BeregningsInformasjonMinstenivatilleggPensjonistpar implements Serializable {


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


}
