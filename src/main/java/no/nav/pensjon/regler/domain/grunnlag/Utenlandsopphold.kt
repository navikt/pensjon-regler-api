package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.kode.LandCti
import java.io.Serializable
import java.util.*

class Utenlandsopphold : Serializable {
    /**
     * Fra og med dato
     */
    var fom: Date? = null

    /**
     * Til og med dato
     */
    var tom: Date? = null

    /**
     * Landet hvor oppholdet har funnet sted
     */
    var land: LandCti? = null

    /**
     * Hvilken pensjonsordning som skal brukes
     */
    var pensjonsordning: String? = null

    /**
     * Har personen bodd i utlandet
     */
    var isBodd = false

    /**
     * Har personen arbeidet i utlandet
     */
    var isArbeidet = false

}