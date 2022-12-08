package no.nav.service.pensjon.regler.to;

import java.util.List;
import java.util.Vector;

import no.nav.domain.pensjon.regler.Merknad;
import no.nav.domain.pensjon.regler.Pakkseddel;

public class KontrollerInformasjonsgrunnlagResponse extends ServiceResponse {


	private List<Merknad> merknadListe = new Vector<Merknad>();

	/**
	 * Pakkseddel for beregningene.
	 */
	private Pakkseddel pakkseddel = new Pakkseddel(true,true);


}
