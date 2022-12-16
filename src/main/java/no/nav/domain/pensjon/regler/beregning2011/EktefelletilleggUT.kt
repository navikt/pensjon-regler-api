package no.nav.domain.pensjon.regler.beregning2011

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti

/* PREG domeneklasse for ytelseskomponent Ektefelletillegg Uføretrygd
 *
 * @author Magnus Bakken - PKFEIL-3285: Feilretting av kopikonstruktør.
 * @author Swiddy de Louw - PKYTON-369 PK-6582 / PK-7106
 */
class EktefelletilleggUT : Ytelseskomponent() {
    /**
     * Årsbeløp for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    private val tidligereBelopAr = 0

    /**
     * Akkumulert netto hittil i året eksklusiv måned for beregningsperiodens fomDato.
     */
    private val nettoAkk = 0

    /**
     * gjenstående beløp brukeren har rett på for året som beregningsperioden starter,
     * og inkluderer måneden det beregnes fra.
     */
    private val nettoRestAr = 0

    /**
     * Inntektsavkortningsbeløp per år, før justering med differansebeløp
     */
    private val avkortningsbelopPerAr = 0

    /**
     * netto ektefelletillegg per måned før konvertering * 12
     */
    private val etForSkattekomp = 0.0

    /**
     * brukers oppjusterte uførepensjon før skattekompensasjon
     */
    private val upForSkattekomp = 0.0

    val ytelsekomponentType = YtelsekomponentTypeCti("UT_ET")

    init {
        ytelsekomponentType = YtelsekomponentTypeCti("UT_ET")
    }
}