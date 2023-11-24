package no.nav.pensjon.regler.domain

import java.io.Serializable

class BatchStatus : Serializable {
    var statusOK = false

    /**
     * Liste av merknader. Beskriver hvorfor g-omregningen feilet for det gjeldende objektet.
     * Dersom statusOK er true finnes ingen merknader.
     */
    var merknadListe: MutableList<Merknad> = mutableListOf()

    val test = 0
}