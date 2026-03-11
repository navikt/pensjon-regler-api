package no.nav.pensjon.regler.domain.simulering

import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.enum.VedtakResultatEnum
import java.io.Serializable
import java.util.*
import java.time.LocalDate

/**
 * Hele resultatet av en simulering.
 */
class Simuleringsresultat : Serializable {
    /**
     * Status på vedtaket
     */
    var statusEnum: VedtakResultatEnum? = null

    /**
     * Beregningen
     */
    var beregning: Beregning? = null

    /**
     * Virkningstidspunkt
     */
    @Deprecated("Use virkLd instead")
    var virk: Date? = null
    var virkLd: LocalDate? = null

    /**
     * Liste av merknader
     */
    var merknadListe: List<Merknad> = mutableListOf()
}