package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.InstoppholdslisteResultat
import java.io.Serializable

/**
 * Response objekt for tjenesten bestemInstitusjonsListe
 *
 */
class InstitusjonsOppholdResponse : Serializable {
    var resultat: InstoppholdslisteResultat? = null
}