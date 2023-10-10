package no.nav.pensjon.regler.domain.grunnlag

import java.io.Serializable

class Forholdstall : Serializable {
    /**
     * Årskull forholdstallet gjelder for. Eks. 1964.
     */
    var arskull: Long = 0

    /**
     * Alder for det gitte Årskullet
     */
    var alder: Long = 0

    /*
       * Angir måned i året. 0 = januar, 11 = desember
       */
    var maned: Long = 0

    /**
     * Det gitte forhodstall for et Årskull, på en gitt alder, i en gitt måned.
     */
    var forholdstall = 0.0
}