package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable

class AntallArOgMnd : Serializable {
    /**
     * Antall år som skal beskrives.
     */
    var antallAr = 0

    /**
     * Antall måneder som skal beskrives.
     */
    var antallMnd = 0

    constructor()
    constructor(antallAr: Int, antallMnd: Int) {
        this.antallAr = antallAr
        this.antallMnd = antallMnd
    }
}