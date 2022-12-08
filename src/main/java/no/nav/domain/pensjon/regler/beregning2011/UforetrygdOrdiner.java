package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/**
 * Ytelseskomponent for uf�retrygd.
 * 
 * @author Steinar Hjellvik (Decisive) PK-6172
 * @author Aasmund Nordstoga (Accenture) PK-9029
 * @author Tatyana Lochehina PK-13673
 */
public class UforetrygdOrdiner extends Ytelseskomponent {


    /**
     * Brukers minsteytelse.
     */
    private Minsteytelse minsteytelse;

    /**
     * Brukers uf�retrygd f�r inntektsavkorting.
     */
    private EgenopptjentUforetrygd egenopptjentUforetrygd;

    /**
     * Angir om egenopptjentUforetrygd er best.
     */
    private boolean egenopptjentUforetrygdBest;

    /**
     * Angir detaljer rundt inntektsavkortingen.
     */
    private AvkortingsinformasjonUT avkortingsinformasjon;

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
     * Utrykker avviket mellom lignet og forventet bel�p ved etteroppgj�r.
     */
    private double periodisertAvvikEtteroppgjor;

    /**
     * Angir fradragPerAr dersom det ikke hadde v�rt arbeidsfors�k i perioden.
     */
    private double fradragPerArUtenArbeidsforsok;

    /**
     * �rsbel�p for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    private int tidligereBelopAr;

    public UforetrygdOrdiner() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_ORDINER");
    }

}
