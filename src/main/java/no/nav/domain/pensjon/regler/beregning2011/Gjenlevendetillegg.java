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
     * Årsbeløp for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    private int tidligereBelopAr;

    /**
     * Årsbeløpet fra knvertert beregningsgrunnlag.
     */
    private double bgKonvertert;

    /**
     * Årsbeløpet fra konvertertberegningsgrunnlagGJT
     */
    private double bgGjenlevendetillegg;

    /**
     * Akkumulert netto hittil i året eksklusiv måned for beregningsperiodens fomDato.
     */
    private int nettoAkk;

    /**
     * gjenstående beløp brukeren har rett på for året som beregningsperioden starter,
     * og inkluderer måneden det beregnes fra.
     */
    private int nettoRestAr;

    /**
     * Inntektsavkortningsbeløp per år, før justering med differansebeløp
     */
    private int avkortningsbelopPerAr;

    /**
     * Angir om gjenlevendetillegget er beregnet som konvertert
     * eller iht. nye regler for gjenlevendetillegg innvilget fom. 01.01.2015.
     */
    private boolean nyttGjenlevendetillegg;

    /**
     * Hvilken faktor gjenlevendetillegget er avkortet med uten hensyn til justering for tidligere avkortet/justert beløp
     */
    private double avkortingsfaktorGJT;

    /**
     * Oppsummering av sentrale felt brukt i utregning av nytt gjenlevendetillegg.
     * Kun satt dersom nyttGjenlevendetillegg er true.
     */
    private GjenlevendetilleggInformasjon gjenlevendetilleggInformasjon;

    /**
     * Utrykker avviket mellom lignet og forventet beløp ved etteroppgjør.
     */
    private double periodisertAvvikEtteroppgjor;

    /**
     * Representerer reduksjon av UFI (brutto uføretrygd) pga eksport.
     */
    private double eksportFaktor;

    public Gjenlevendetillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_GJT");
    }
}
