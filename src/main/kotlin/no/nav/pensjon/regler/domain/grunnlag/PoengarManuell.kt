package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.AvtaleLandEnum
import java.io.Serializable
import java.util.*
import java.time.LocalDate

/**
 * Klassen beskriver et poengår opptjent i utlandet. Settes av saksbehandler.
 */
class PoengarManuell : Serializable {
    /**
     * Poengåret fra og med dato.
     */
    @Deprecated("Use fomLd instead")
    var fom: Date? = null
    var fomLd: LocalDate? = null

    /**
     * Poengåret til og med dato.
     */
    @Deprecated("Use tomLd instead")
    var tom: Date? = null
    var tomLd: LocalDate? = null

    /**
     * Angir om poengåret skal brukes i pro rata beregning.
     */
    var ikkeProrata = false

    /**
     * Angir om poengåret skal brukes i alternativ pro rata beregning.
     */
    var ikkeAlternativProrata = false

    /**
     * Avtaleland som poengår ble opptjent i.
     */
    var avtalelandEnum: AvtaleLandEnum? = null
}