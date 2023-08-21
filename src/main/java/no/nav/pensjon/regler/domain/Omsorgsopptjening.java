package no.nav.pensjon.regler.domain;

/**
 * Interface som implementeres av {@link no.nav.pensjon.regler.domain.beregning.Poengtall} og {@link no.nav.pensjon.regler.domain.beregning2011.OpptjeningUT}
 *
 * @author �yvind Skyt�en (Accenture) PK-6782
 */
public interface Omsorgsopptjening {

    /**
     * Gitt �r for opptjeningen
     *
     * @return et �r
     */
    public int getOpptjeningsar();

    /**
     * Inntekt for aktuelt �r
     *
     * @return en inntekt
     */
    public double getVerdi();

    /**
     * @return Justert bel�p for aktuelt �r. Trengs for sortering av OpptjeningUT, ref. PK-1214
     */
    public double getJustertBelop();

    /**
     * @param justertBelop Justert bel�p som skal settes. Trengs av tekniske �rsaker for � forhindre at implementerende klasser f�r read-only felt.
     */
    public void setJustertBelop(double justertBelop);

    /**
     * Angir om det er registrert omsorgsopptjening for aktuelt �r
     *
     * @return om det er omsorgsopptjening aktuelt �r
     */
    public boolean isOmsorg();

    /**
     * Angir om det er registrert inntekt i avtaleland for aktuelt �r
     *
     * @return om det er inntekt i avtaleland aktuelt �r
     */
    public boolean isInntektIAvtaleland();

    /**
     * Setter for dette feltet trengs av tekniske �rsaker slik at dette feltet ikke blir read-only i implementerende klasser.
     *
     * @param inntektIAvtaleland Er det registrert inntekt i avtaleland for aktuelt �r?
     */
    public void setInntektIAvtaleland(boolean inntektIAvtaleland);
}
