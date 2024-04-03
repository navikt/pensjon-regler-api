package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.InstoppholdslisteResultat


/**
 * Response objekt for tjenesten bestemInstitusjonsListe
 *
 */
class InstitusjonsOppholdResponse : ServiceResponse() {
    var resultat: InstoppholdslisteResultat? = null
}