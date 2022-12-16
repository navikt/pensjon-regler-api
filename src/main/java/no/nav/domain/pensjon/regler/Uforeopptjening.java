package no.nav.domain.pensjon.regler;

import java.io.Serializable;

public class Uforeopptjening implements Serializable {
    

    /*
     * Beløp for hva uføreopptjeningen utgjør.
     */
    private double belop;
    /*
     * Angir hvorvidt opptjeningen baseres på en proRata beregnet uførepensjon.
     */
    private boolean proRataBeregnetUP;
    /*
     * Angir poengtallet som ligger til grunn utregningen.
     */
    private double poengtall;
    /*
     * Uførepensjonens uføregrad.
     */
    private int ufg;
    /*
     * Antatt Inntekt.
     */
    private double antattInntekt;
    /*
     * Antatt Inntekt. ProRata variant.
     */
    private double antattInntekt_proRata;
    /*
     * Angir hvor stor andel av opptjeningen kan benyttes i året (fra 0.00 til 1.00).
     */
    private double andel_proRata;
    /*
     * Poengår teller for proRata brøk.
     */
    private int poengarTeller_proRata;
    /*
     * Poengår nevner for proRata brøk.
     */
    private int poengarNevner_proRata;
    /*
     * Antall fremtidige år, etter avkortning fra evt redFTT.
     */
    private int antFremtidigeAr_proRata;
    /*
     * Angir yrkesskade delen av opptjeningen.
     */
    private Yrkesskadeopptjening yrkesskadeopptjening;

    /**
     * Angir om opptjening er basert på uføretrygd (true) eller uførepensjon (false).
     */
    private boolean uforetrygd;
	
	/**
	* Angir om årets uføreopptjening er relatert til uføreperiode hvor uføretidspunktet er konvertert fra uførepensjon.
	*/
	private boolean konvertertUFT;


}
