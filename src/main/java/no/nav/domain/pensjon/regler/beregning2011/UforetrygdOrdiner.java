package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/**
 * Ytelseskomponent for uføretrygd.
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
     * Brukers uføretrygd før inntektsavkorting.
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
     * Utrykker avviket mellom lignet og forventet beløp ved etteroppgjør.
     */
    private double periodisertAvvikEtteroppgjor;

    /**
     * Angir fradragPerAr dersom det ikke hadde vært arbeidsforsøk i perioden.
     */
    private double fradragPerArUtenArbeidsforsok;

    /**
     * Årsbeløp for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    private int tidligereBelopAr;

    public UforetrygdOrdiner() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_ORDINER");
    }

}
