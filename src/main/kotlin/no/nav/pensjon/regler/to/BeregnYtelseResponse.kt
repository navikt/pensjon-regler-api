package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.beregning.Beregning
import java.util.*

/**
 * Klassen representerer hele resultatet fra et kall til en regeltjeneste for ytelsesberegning.
 */
class BeregnYtelseResponse : ServiceResponse() {
    /**
     * En liste av beregninger som utgjør resultatet.
     */
    var beregningsListe: List<Beregning> = Vector()

}