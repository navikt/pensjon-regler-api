package no.nav.domain.pensjon.regler.beregning2011

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti

/* PREG domeneklasse for ytelseskomponent Ektefelletillegg Uf�retrygd
 *
 * @author Magnus Bakken - PKFEIL-3285: Feilretting av kopikonstrukt�r.
 * @author Swiddy de Louw - PKYTON-369 PK-6582 / PK-7106
 */
class EktefelletilleggUT : Ytelseskomponent() {
    /**
     * �rsbel�p for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    private val tidligereBelopAr = 0

    /**
     * Akkumulert netto hittil i �ret eksklusiv m�ned for beregningsperiodens fomDato.
     */
    private val nettoAkk = 0

    /**
     * gjenst�ende bel�p brukeren har rett p� for �ret som beregningsperioden starter,
     * og inkluderer m�neden det beregnes fra.
     */
    private val nettoRestAr = 0

    /**
     * Inntektsavkortningsbel�p per �r, f�r justering med differansebel�p
     */
    private val avkortningsbelopPerAr = 0

    /**
     * netto ektefelletillegg per m�ned f�r konvertering * 12
     */
    private val etForSkattekomp = 0.0

    /**
     * brukers oppjusterte uf�repensjon f�r skattekompensasjon
     */
    private val upForSkattekomp = 0.0

    val ytelsekomponentType = YtelsekomponentTypeCti("UT_ET")

    init {
        ytelsekomponentType = YtelsekomponentTypeCti("UT_ET")
    }
}