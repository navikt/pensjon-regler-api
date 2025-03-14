package no.nav.pensjon.regler.domain.simulering

import no.nav.pensjon.regler.domain.enum.AFPtypeEnum
import no.nav.pensjon.regler.domain.enum.SimuleringTypeEnum
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.io.Serializable
import java.util.*

/**
 * Simulering
 */
class Simulering : Serializable {

    /**
     * Type simulering
     */
    var simuleringTypeEnum: SimuleringTypeEnum? = null

    /**
     * Type AFP ordning
     */
    var afpOrdningEnum: AFPtypeEnum? = null

    /**
     * Dato for når bruker ønsker å simulere uttak av pensjon fra.
     */
    var uttaksdato: Date? = null

    /**
     * Liste av tilknyttede personer.
     */
    var persongrunnlagListe: List<Persongrunnlag> = mutableListOf()
    var vilkarsvedtakliste: List<VilkarsVedtak> = mutableListOf()
}