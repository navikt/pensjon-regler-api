package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import java.io.Serializable
import java.util.*
import java.time.LocalDate

class BeregnetUtbetalingsperiode() : Serializable {
    /**
     * Periodens startdato.
     */
    @Deprecated("Use fomDatoLd instead")
    var fomDato: Date? = null
    var fomDatoLd: LocalDate? = null

    /**
     * Periodens sluttdato.
     */
    @Deprecated("Use tomDatoLd instead")
    var tomDato: Date? = null
    var tomDatoLd: LocalDate? = null

    /**
     * Uføregrad for perioden
     */
    var uforegrad = 0

    /**
     * Yrkesskadegrad for perioden
     */
    var yrkesskadegrad = 0

    /**
     * Antall fellesbarn det er innvilget barnetillegg for i perioden.
     * Vil kun være angitt for fremtidige perioder i kontekst av etteroppgjør
     */
    var antallFellesbarn = 0

    /**
     * Antall særkullsbarn det er innvilget barnetillegg for i perioden.
     * Vil kun være angitt for fremtidige perioder i kontekst av etteroppgjør
     */
    var antallSerkullsbarn = 0
    var ytelseskomponenter: Map<String, Ytelseskomponent> = mutableMapOf()

    var afpOffentligLivsvarigGrunnlag: AfpOffentligLivsvarigGrunnlag? = null
}