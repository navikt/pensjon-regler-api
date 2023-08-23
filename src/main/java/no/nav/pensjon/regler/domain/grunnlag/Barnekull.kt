package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable

class Barnekull : Serializable {
    /**
     * Antall barn i kullet.
     */
    var antallBarn = 0

    /**
     * Angir om persondetaljen brukes som grunnlag på kravet.
     */
    var isBruk: Boolean = true
}