package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.LandkodeEnum
import java.io.Serializable
import java.util.*
import java.time.LocalDate

class Utenlandsopphold : Serializable {
    /**
     * Fra og med dato
     */
    @Deprecated("Use fomLd instead")
    var fom: Date? = null
    var fomLd: LocalDate? = null

    /**
     * Til og med dato
     */
    @Deprecated("Use tomLd instead")
    var tom: Date? = null
    var tomLd: LocalDate? = null

    /**
     * Landet hvor oppholdet har funnet sted
     */
    var landEnum: LandkodeEnum? = null

    /**
     * Hvilken pensjonsordning som skal brukes
     */
    var pensjonsordning: String? = null

    /**
     * Har personen bodd i utlandet
     */
    var bodd = false

    /**
     * Har personen arbeidet i utlandet
     */
    var arbeidet = false

}