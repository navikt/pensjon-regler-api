package no.nav.pensjon.regler.domain.simulering

import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag
import no.nav.pensjon.regler.domain.kode.AfpOrdningTypeCti
import no.nav.pensjon.regler.domain.kode.SimuleringTypeCti
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
    var simuleringType: SimuleringTypeCti? = null

    /**
     * Type AFP ordning
     */
    var afpOrdning: AfpOrdningTypeCti? = null

    /**
     * Dato for når bruker ønsker å simulere uttak av pensjon fra.
     */
    var uttaksdato: Date? = null

    /**
     * Liste av tilknyttede personer.
     */
    var persongrunnlagListe: MutableList<Persongrunnlag> = mutableListOf()
    var vilkarsvedtakliste: MutableList<VilkarsVedtak> = mutableListOf()
}