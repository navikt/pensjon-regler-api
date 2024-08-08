package no.nav.pensjon.regler.domain.simulering

import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.enum.VedtakResultatEnum
import no.nav.pensjon.regler.domain.kode.VilkarsvedtakResultatCti
import java.io.Serializable
import java.util.*

/**
 * Hele resultatet av en simulering.
 */
class Simuleringsresultat : Serializable {
    /**
     * Status på vedtaket
     */
    var status: VilkarsvedtakResultatCti? = null
    var statusEnum: VedtakResultatEnum? = null

    /**
     * Beregningen
     */
    var beregning: Beregning? = null

    /**
     * Virkningstidspunkt
     */
    var virk: Date? = null

    /**
     * Liste av merknader
     */
    var merknadListe: List<Merknad> = mutableListOf()
}