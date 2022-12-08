package no.nav.domain.pensjon.regler.beregning2011;

/**
 * Siste aldersberegning 2016 som arver SisteAldersberegning2011. Har en pub2025 i tilleg til pub2011.
 */

/**
 * @author Geir Anders Nilsen
 * @author Magnus Bakken (Accenture), PK-20716
 */
public class SisteAldersberegning2016 extends SisteAldersberegning2011 {


    /**
     * Pensjon under utbetaling fra beregningsresultatet for AP2011
     */
    private PensjonUnderUtbetaling pensjonUnderUtbetaling2011;

    /**
     * Pensjon under utbetaling fra beregningsresultatet for AP2011, regnet uten gjenlevenderett
     * Feltet brukes ved revurdering av AP2016 når bruker har gjenlevendetillegg.
     */
    private PensjonUnderUtbetaling pensjonUnderUtbetaling2011UtenGJR;

    /**
     * Pensjon under utbetaling fra beregningsresultatet for AP2025
     */
    private PensjonUnderUtbetaling pensjonUnderUtbetaling2025;

    /**
     * Restpensjon regnet uten gjenlevenderettighet.
     * Feltet brukes ved revurdering av AP2016 når bruker har gjenlevendetillegg.
     */
    private Basispensjon restpensjonUtenGJR;

    /**
     * Basispensjon regnet uten gjenlevenderettighet.
     * Feltet brukes ved revurdering av AP2016 når bruker har gjenlevendetillegg.
     */
    private Basispensjon basispensjonUtenGJR;

}
