package no.nav.pensjon.regler.domain;

/**
 * Interface som implementeres av {@link no.nav.pensjon.regler.domain.beregning.Poengtall} og {@link no.nav.pensjon.regler.domain.beregning2011.OpptjeningUT}
 *
 * @author Øyvind Skytøen (Accenture) PK-6782
 */
public interface Omsorgsopptjening {

    /**
     * Gitt år for opptjeningen
     *
     * @return et År
     */
    public int getOpptjeningsar();

    /**
     * Inntekt for aktuelt år
     *
     * @return en inntekt
     */
    public double getVerdi();

    /**
     * @return Justert beløp for aktuelt år. Trengs for sortering av OpptjeningUT, ref. PK-1214
     */
    public double getJustertBelop();

    /**
     * @param justertBelop Justert beløp som skal settes. Trengs av tekniske årsaker for å forhindre at implementerende klasser får read-only felt.
     */
    public void setJustertBelop(double justertBelop);

    /**
     * Angir om det er registrert omsorgsopptjening for aktuelt år
     *
     * @return om det er omsorgsopptjening aktuelt år
     */
    public boolean isOmsorg();

    /**
     * Angir om det er registrert inntekt i avtaleland for aktuelt år
     *
     * @return om det er inntekt i avtaleland aktuelt år
     */
    public boolean isInntektIAvtaleland();

    /**
     * Setter for dette feltet trengs av tekniske årsaker slik at dette feltet ikke blir read-only i implementerende klasser.
     *
     * @param inntektIAvtaleland Er det registrert inntekt i avtaleland for aktuelt år?
     */
    public void setInntektIAvtaleland(boolean inntektIAvtaleland);
}
