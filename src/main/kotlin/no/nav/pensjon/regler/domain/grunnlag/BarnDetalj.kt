package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.PenPerson
import java.io.Serializable
import java.util.*
import java.time.LocalDate

class BarnDetalj : Serializable {
    /**
     * Angir barnets andre forelder enn søker.
     */
    var annenForelder: PenPerson? = null

    /**
     * Angir om barnet bor med en begge foreldre.
     * "true" betyr fellesbarn, "false" betyr særkullsbarn.
     */
    var borMedBeggeForeldre = false

    /**
     * Fra-og-med dato for når barnet bor sammen med begge foreldrene.
     */
    @Deprecated("Use borFomDatoLd instead")
    var borFomDato: Date? = null
    var borFomDatoLd: LocalDate? = null

    /**
     * Til-og-med dato for når barnet bor sammen med begge foreldrene.
     */
    @Deprecated("Use borTomDatoLd instead")
    var borTomDato: Date? = null
    var borTomDatoLd: LocalDate? = null

    /**
     * Angir om barnet har hatt inntekt over 1G.
     */
    var inntektOver1G = false

    /**
     * Angir hvorvidt barnet er under utdanning.
     */
    var underUtdanning = false
}