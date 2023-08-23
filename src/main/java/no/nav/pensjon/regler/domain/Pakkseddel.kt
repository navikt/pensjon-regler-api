package no.nav.pensjon.regler.domain

import java.io.Serializable

/**
 * Denne klassen representerer en pakkseddel som leveres sammen med resultatet
 * fra en regeltjeneste.
 */
class Pakkseddel : Serializable {
    /**
     * Angir en totalvurdering for innholdet i resultatet som returneres.
     * Dersom `resultatOK` er `true` betyr dette at PREG anser resultatet som fullstendig,
     * og kan brukes videre i prosessflyten. `false` betyr at PREG anser resultatet som ufullstendig, og at det må
     * sendes til saksbehandler for manuell behandling.
     * For PEN vil resultatOK brukes til å avgjøre om resultatet skal lagres eller ikke.
     */
    var kontrollTjenesteOk = true
    var annenTjenesteOk = true

    /**
     * Liste av merknader. Beskriver hvordan PREG kom frem til `kontrollTjenesteOk`.
     */
    var merknadListe: List<Merknad> = mutableListOf()

    /**
     * Hvilken versjon av PREG som er i bruk.
     */
    private var PREG_version: String? = null

    /**
     * Hvilken type testsatstabell som er i bruk.
     */
    private var PREG_TestSatstabellType: String? = null

    /**
     * Hvilken versjon av satstabeller som er i bruk.
     */
    private var PREG_satstabellVersion: String? = null

}