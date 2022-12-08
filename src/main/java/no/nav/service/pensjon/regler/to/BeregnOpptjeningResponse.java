package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.List;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.grunnlag.Pensjonsbeholdning;

public class BeregnOpptjeningResponse extends ServiceResponse {

	private ArrayList<Pensjonsbeholdning> beholdninger; 
	
	/**
	 * Pakkseddel for svaret.
	 */
	private Pakkseddel pakkseddel = new Pakkseddel(true, true);

}
