package no.nav.pensjon.regler.domain

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import no.nav.pensjon.regler.domain.beregning.Poengtall
import no.nav.pensjon.regler.domain.beregning2011.OpptjeningUT

@JsonSubTypes(
    JsonSubTypes.Type(value = Poengtall::class),
    JsonSubTypes.Type(value = OpptjeningUT::class)
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
interface Omsorgsopptjening {
    /**
     * Gitt år for opptjeningen
     *
     * @return et År
     */
    val opptjeningsar: Int

    /**
     * Inntekt for aktuelt år
     *
     * @return en inntekt
     */
    val verdi: Double

    /**
     * @return Justert beløp for aktuelt år. Trengs for sortering av OpptjeningUT, ref. PK-1214
     */
    /**
     * @param justertBelop Justert beløp som skal settes. Trengs av tekniske årsaker for å forhindre at implementerende klasser får read-only felt.
     */
    var justertBelop: Double

    /**
     * Angir om det er registrert omsorgsopptjening for aktuelt år
     *
     * @return om det er omsorgsopptjening aktuelt år
     */
    val omsorg: Boolean

    /**
     * Angir om det er registrert inntekt i avtaleland for aktuelt år
     *
     * @return om det er inntekt i avtaleland aktuelt år
     */
    /**
     * Setter for dette feltet trengs av tekniske årsaker slik at dette feltet ikke blir read-only i implementerende klasser.
     *
     * @param inntektIAvtaleland Er det registrert inntekt i avtaleland for aktuelt år?
     */
    var inntektIAvtaleland: Boolean

}