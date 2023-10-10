package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti

/**
 * Ytelseskomponent for uføretrygd.
 */
class UforetrygdOrdiner : Ytelseskomponent(), UforetrygdYtelseskomponent {
    /**
     * Brukers minsteytelse.
     */
    var minsteytelse: Minsteytelse? = null

    /**
     * Brukers uføretrygd før inntektsavkorting.
     */
    var egenopptjentUforetrygd: EgenopptjentUforetrygd? = null

    /**
     * Angir om egenopptjentUforetrygd er best.
     */
    var egenopptjentUforetrygdBest = false

    /**
     * Angir detaljer rundt inntektsavkortingen.
     */
    var avkortingsinformasjon: AvkortingsinformasjonUT? = null

    /**
     * Akkumulert netto hittil i året eksklusiv måned for beregningsperiodens fomDato.
     */
    var nettoAkk = 0

    /**
     * gjenstående beløp brukeren har rett på for året som beregningsperioden starter,
     * og inkluderer måneden det beregnes fra.
     */
    var nettoRestAr = 0

    /**
     * Inntektsavkortningsbeløp per år, før justering med differansebeløp
     */
    var avkortningsbelopPerAr = 0

    /**
     * Utrykker avviket mellom lignet og forventet beløp ved etteroppgjør.
     */
    var periodisertAvvikEtteroppgjor = 0.0

    /**
     * Angir fradragPerAr dersom det ikke hadde vært arbeidsforsøk i perioden.
     */
    var fradragPerArUtenArbeidsforsok = 0.0

    /**
     * årsbeløp for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    override var tidligereBelopAr = 0

    init {
        ytelsekomponentType = YtelsekomponentTypeCti("UT_ORDINER")
    }
}