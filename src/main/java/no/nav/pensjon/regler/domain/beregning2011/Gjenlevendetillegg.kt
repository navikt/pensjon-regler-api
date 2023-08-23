package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti
import no.nav.pensjon.regler.domain.util.formula.Formel
import no.nav.pensjon.regler.domain.util.formula.IFormelProvider

class Gjenlevendetillegg() : Ytelseskomponent(), UforetrygdYtelseskomponent, IFormelProvider {
    /**
     * årsbeløp for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    override var tidligereBelopAr = 0

    /**
     * årsbeløpet fra knvertert beregningsgrunnlag.
     */
    var bgKonvertert = 0.0

    /**
     * årsbeløpet fra konvertertberegningsgrunnlagGJT
     */
    var bgGjenlevendetillegg = 0.0

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
     * Angir om gjenlevendetillegget er beregnet som konvertert
     * eller iht. nye regler for gjenlevendetillegg innvilget fom. 01.01.2015.
     */
    var nyttGjenlevendetillegg = false
    /**
     * @return the avkortingsfaktorGJT
     */
    /**
     * @param avkortingsfaktorGJT the avkortingsfaktorGJT to set
     */
    /**
     * Hvilken faktor gjenlevendetillegget er avkortet med uten hensyn til justering for tidligere avkortet/justert beløp
     */
    var avkortingsfaktorGJT = 0.0

    /**
     * Oppsummering av sentrale felt brukt i utregning av nytt gjenlevendetillegg.
     * Kun satt dersom nyttGjenlevendetillegg er true.
     */
    var gjenlevendetilleggInformasjon: GjenlevendetilleggInformasjon? = null

    /**
     * Utrykker avviket mellom lignet og forventet beløp ved etteroppgjør.
     */
    var periodisertAvvikEtteroppgjor = 0.0

    /**
     * Representerer reduksjon av UFI (brutto uføretrygd) pga eksport.
     */
    var eksportFaktor = 0.0

    /**
     * Grunnlaget for gjenlevendetillegget
     */
    var grunnlagGjenlevendetillegg = 0.0

    /**
     * Map av formler brukt i beregning av Tilleggspensjon.
     */
    override val formelMap: HashMap<String, Formel> = hashMapOf()

    init {
        ytelsekomponentType = YtelsekomponentTypeCti("UT_GJT")
    }

    override val formelPrefix: String
        get() = ytelsekomponentType?.kode!!
}