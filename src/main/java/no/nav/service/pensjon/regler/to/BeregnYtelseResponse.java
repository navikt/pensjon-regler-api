package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning.Beregning;

/**
 * Klassen representerer hele resultatet fra et kall til en regeltjeneste for ytelsesberegning.
 */
public class BeregnYtelseResponse extends ServiceResponse {

	/**
	 * Pakkseddel for beregningene.
	 */
	private Pakkseddel pakkseddel = new Pakkseddel(true, true);
	/**
	 * En liste av beregninger som utgjør resultatet.
	 */
	private List <Beregning> beregningsListe = new Vector<Beregning>();


}
