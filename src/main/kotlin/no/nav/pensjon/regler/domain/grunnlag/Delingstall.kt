package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable

class Delingstall : Serializable {
    /**
     * Årskull delingstallet gjelder for. Eks. 1964.
     */
    var arskull: Long = 0

    /**
     * Alder for det gitte Årskullet
     */
    var alder: Long = 0

    /**
     * Angir måned i året. 0 = januar, 11 = desember
     */
    var maned: Long = 0

    /**
     * Det gitte delingstall for et årskull, på en gitt alder, i en gitt måned.
     */
    var delingstall = 0.0

}