package no.nav.service.pensjon.regler.to;

import java.util.List;
import java.util.Vector;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

public class VilkarsprovResponse extends ServiceResponse{

	
	
	List<VilkarsVedtak> vedtaksliste = new Vector<VilkarsVedtak>();

	/**
	 * Pakkseddel for beregningene.
	 */
	private Pakkseddel pakkseddel = new Pakkseddel(true, true);

}
