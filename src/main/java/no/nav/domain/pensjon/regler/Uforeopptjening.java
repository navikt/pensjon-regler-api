package no.nav.domain.pensjon.regler;

import java.io.Serializable;

public class Uforeopptjening implements Serializable {
    

    /*
     * Bel�p for hva uf�reopptjeningen utgj�r.
     */
    private double belop;
    /*
     * Angir hvorvidt opptjeningen baseres p� en proRata beregnet uf�repensjon.
     */
    private boolean proRataBeregnetUP;
    /*
     * Angir poengtallet som ligger til grunn utregningen.
     */
    private double poengtall;
    /*
     * Uf�repensjonens uf�regrad.
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
     * Angir hvor stor andel av opptjeningen kan benyttes i �ret (fra 0.00 til 1.00).
     */
    private double andel_proRata;
    /*
     * Poeng�r teller for proRata br�k.
     */
    private int poengarTeller_proRata;
    /*
     * Poeng�r nevner for proRata br�k.
     */
    private int poengarNevner_proRata;
    /*
     * Antall fremtidige �r, etter avkortning fra evt redFTT.
     */
    private int antFremtidigeAr_proRata;
    /*
     * Angir yrkesskade delen av opptjeningen.
     */
    private Yrkesskadeopptjening yrkesskadeopptjening;

    /**
     * Angir om opptjening er basert p� uf�retrygd (true) eller uf�repensjon (false).
     */
    private boolean uforetrygd;
	
	/**
	* Angir om �rets uf�reopptjening er relatert til uf�reperiode hvor uf�retidspunktet er konvertert fra uf�repensjon.
	*/
	private boolean konvertertUFT;


}
