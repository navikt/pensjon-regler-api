package no.nav.service.pensjon.regler.to;

import java.util.List;
import java.util.Vector;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;
import no.stelvio.common.transferobject.ServiceResponse;

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

	/**
	 * Read only property for vedtaksliste as array
	 * @return array of VilkarsVedtak
	 */
	public VilkarsVedtak[] getVilkarsvedtakListeAsArray() {
		return (vedtaksliste != null ? this.vedtaksliste.toArray(new VilkarsVedtak[this.vedtaksliste.size()]) : new VilkarsVedtak[0]);
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
