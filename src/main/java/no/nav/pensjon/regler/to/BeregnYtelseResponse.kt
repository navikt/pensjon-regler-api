package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import no.nav.pensjon.regler.domain.beregning.Beregning
import java.io.Serializable
import java.util.Vector

/**
 * Klassen representerer hele resultatet fra et kall til en regeltjeneste for ytelsesberegning.
 */
class BeregnYtelseResponse : Serializable {
    /**
     * Pakkseddel for beregningene.
     */
    var pakkseddel = Pakkseddel()

    /**
     * En liste av beregninger som utgjør resultatet.
     */
    var beregningListe: List<Beregning> = Vector()
}