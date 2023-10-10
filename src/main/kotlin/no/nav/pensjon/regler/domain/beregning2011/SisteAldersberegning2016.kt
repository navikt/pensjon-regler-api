package no.nav.pensjon.regler.domain.beregning2011

class SisteAldersberegning2016 : SisteAldersberegning2011() {
    /**
     * Pensjon under utbetaling fra beregningsresultatet for AP2011
     */
    var pensjonUnderUtbetaling2011: PensjonUnderUtbetaling? = null

    /**
     * Pensjon under utbetaling fra beregningsresultatet for AP2011, regnet uten gjenlevenderett
     * Feltet brukes ved revurdering av AP2016 når bruker har gjenlevendetillegg.
     */
    var pensjonUnderUtbetaling2011UtenGJR: PensjonUnderUtbetaling? = null

    /**
     * Pensjon under utbetaling fra beregningsresultatet for AP2025
     */
    var pensjonUnderUtbetaling2025: PensjonUnderUtbetaling? = null

    /**
     * Restpensjon regnet uten gjenlevenderettighet.
     * Feltet brukes ved revurdering av AP2016 når bruker har gjenlevendetillegg.
     */
    var restpensjonUtenGJR: Basispensjon? = null

    /**
     * Basispensjon regnet uten gjenlevenderettighet.
     * Feltet brukes ved revurdering av AP2016 når bruker har gjenlevendetillegg.
     */
    var basispensjonUtenGJR: Basispensjon? = null

}