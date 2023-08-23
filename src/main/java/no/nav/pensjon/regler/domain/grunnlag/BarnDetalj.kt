package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.PenPerson
import java.io.Serializable
import java.util.*

class BarnDetalj : Serializable {
    /**
     * Angir barnets andre forelder enn søker.
     */
    var annenForelder: PenPerson? = null

    /**
     * Angir om barnet bor med en begge foreldre.
     * "true" betyr fellesbarn, "false" betyr særkullsbarn.
     */
    var isBorMedBeggeForeldre = false

    /**
     * Fra-og-med dato for når barnet bor sammen med begge foreldrene.
     */
    var borFomDato: Date? = null

    /**
     * Til-og-med dato for når barnet bor sammen med begge foreldrene.
     */
    var borTomDato: Date? = null

    /**
     * Angir om barnet har hatt inntekt over 1G.
     */
    var isInntektOver1G = false

    /**
     * Angir hvorvidt barnet er under utdanning.
     */
    var isUnderUtdanning = false
}