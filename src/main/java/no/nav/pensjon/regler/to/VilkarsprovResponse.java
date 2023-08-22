package no.nav.pensjon.regler.to;

import java.util.List;
import java.util.Vector;

import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;

public class VilkarsprovResponse extends ServiceResponse{

	private static final long serialVersionUID = -1711932603705854178L;
	
	List<VilkarsVedtak> vedtaksliste = new Vector<VilkarsVedtak>();

	/**
	 * Pakkseddel for beregningene.
	 */
	private Pakkseddel pakkseddel = new Pakkseddel(true, true);

	public VilkarsprovResponse() {
		super();
	}

	public VilkarsprovResponse(List<VilkarsVedtak> vedtaksliste)
	{
		this.vedtaksliste = vedtaksliste;
	}

	public List<VilkarsVedtak> getVedtaksliste() {
		return vedtaksliste;
	}

	public void setVedtaksliste(List<VilkarsVedtak> vedtaksliste) {
		this.vedtaksliste = vedtaksliste;
	}

	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}
}
