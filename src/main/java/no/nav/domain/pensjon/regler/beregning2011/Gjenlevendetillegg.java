package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/**
 * @author Steinar Hjellvik (Decisive) PK-7113
 * @author Swiddy de Louw (Capgemini) PK-7113
 * @author Steinar Hjellvik (Decisive) - PK-11391
 * @author Swiddy de Louw (Capgemini) - PK-11041
 * @author Tatyana Lochehina PK-13673
 */
public class Gjenlevendetillegg extends Ytelseskomponent {



    /**
     * �rsbel�p for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    private int tidligereBelopAr;

    /**
     * �rsbel�pet fra knvertert beregningsgrunnlag.
     */
    private double bgKonvertert;

    /**
     * �rsbel�pet fra konvertertberegningsgrunnlagGJT
     */
    private double bgGjenlevendetillegg;

    /**
     * Akkumulert netto hittil i �ret eksklusiv m�ned for beregningsperiodens fomDato.
     */
    private int nettoAkk;

    /**
     * gjenst�ende bel�p brukeren har rett p� for �ret som beregningsperioden starter,
     * og inkluderer m�neden det beregnes fra.
     */
    private int nettoRestAr;

    /**
     * Inntektsavkortningsbel�p per �r, f�r justering med differansebel�p
     */
    private int avkortningsbelopPerAr;

    /**
     * Angir om gjenlevendetillegget er beregnet som konvertert
     * eller iht. nye regler for gjenlevendetillegg innvilget fom. 01.01.2015.
     */
    private boolean nyttGjenlevendetillegg;

    /**
     * Hvilken faktor gjenlevendetillegget er avkortet med uten hensyn til justering for tidligere avkortet/justert bel�p
     */
    private double avkortingsfaktorGJT;

    /**
     * Oppsummering av sentrale felt brukt i utregning av nytt gjenlevendetillegg.
     * Kun satt dersom nyttGjenlevendetillegg er true.
     */
    private GjenlevendetilleggInformasjon gjenlevendetilleggInformasjon;

    /**
     * Utrykker avviket mellom lignet og forventet bel�p ved etteroppgj�r.
     */
    private double periodisertAvvikEtteroppgjor;

    /**
     * Representerer reduksjon av UFI (brutto uf�retrygd) pga eksport.
     */
    private double eksportFaktor;

    public Gjenlevendetillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_GJT");
    }
}
