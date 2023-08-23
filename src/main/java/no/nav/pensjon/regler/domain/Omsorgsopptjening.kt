package no.nav.pensjon.regler.domain

interface Omsorgsopptjening {
    /**
     * Gitt år for opptjeningen
     *
     * @return et år
     */
    fun getOpptjeningsar(): Int

    /**
     * Inntekt for aktuelt år
     *
     * @return en inntekt
     */
    fun getVerdi(): Double

    /**
     * Angir om det er registrert omsorgsopptjening for aktuelt år
     *
     * @return om det er omsorgsopptjening aktuelt år
     */
    fun isOmsorg(): Boolean

}