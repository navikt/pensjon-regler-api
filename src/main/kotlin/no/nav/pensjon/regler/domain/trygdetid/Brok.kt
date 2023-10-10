package no.nav.pensjon.regler.domain.trygdetid

import java.io.Serializable

/**
 * brøk som brukes til
 * - (prorata) beregning av pensjon
 * - antall måneder barnetillegg
 */
class Brok : Serializable {
    /**
     * brøkens teller.
     */
    var teller = 0

    /**
     * brøkens nevner.
     */
    var nevner = 0

    constructor()
    constructor(brok: Brok) : super() {
        teller = brok.teller
        nevner = brok.nevner
    }
}