package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;
import no.stelvio.common.transferobject.ServiceResponse;

public class VilkarsprovHalvpensjonResponse extends ServiceResponse {
	private static final long serialVersionUID = -8959660516578315768L;
	
	private VilkarsVedtak vilkarsvedtak;
	private Pakkseddel pakkseddel;
	
	public VilkarsprovHalvpensjonResponse() {
		super();
	}
	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}
	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}
	public VilkarsVedtak getVilkarsvedtak() {
		return vilkarsvedtak;
	}
	public void setVilkarsvedtak(VilkarsVedtak vilkarsvedtak) {
		this.vilkarsvedtak = vilkarsvedtak;
	}
}
