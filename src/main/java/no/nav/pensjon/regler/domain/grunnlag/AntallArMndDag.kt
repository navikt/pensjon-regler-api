package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable

/**
 * @author Lars Hartvigsen (Decisive), PK-5610
 */
class AntallArMndDag : Serializable {
    /**
     * Antall år som skal beskrives.
     */
    var antallAr = 0

    /**
     * Antall måneder som skal beskrives.
     */
    var antallMnd = 0

    /**
     * Antall dager som skal beskrives.
     */
    var antallDager = 0

}