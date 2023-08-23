package no.nav.pensjon.regler.domain

import java.io.Serializable

class BatchStatus : Serializable {
    var isStatusOK = false

    /**
     * Liste av merknader. Beskriver hvorfor g-omregningen feilet for det gjeldende objektet.
     * Dersom statusOK er true finnes ingen merknader.
     */
    var merknadListe: List<Merknad> = mutableListOf()
}