package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent
import java.io.Serializable
import java.util.*

class BeregnetUtbetalingsperiode() : Serializable {
    /**
     * Periodens startdato.
     */
    var fomDato: Date? = null

    /**
     * Periodens sluttdato.
     */
    var tomDato: Date? = null

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