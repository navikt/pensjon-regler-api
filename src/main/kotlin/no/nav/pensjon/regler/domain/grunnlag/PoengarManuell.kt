package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.AvtaleLandEnum
import no.nav.pensjon.regler.domain.kode.AvtalelandCti
import java.io.Serializable
import java.util.*

/**
 * Klassen beskriver et poengår opptjent i utlandet. Settes av saksbehandler.
 */
class PoengarManuell : Serializable {
    /**
     * Poengåret fra og med dato.
     */
    var fom: Date? = null

    /**
     * Poengåret til og med dato.
     */
    var tom: Date? = null

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
    var avtaleland: AvtalelandCti? = null
    var avtalelandEnum: AvtaleLandEnum? = null
}