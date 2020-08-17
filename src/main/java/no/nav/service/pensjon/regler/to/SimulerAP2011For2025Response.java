package no.nav.service.pensjon.regler.to;


import no.nav.domain.pensjon.regler.Pakkseddel;
import no.stelvio.common.transferobject.ServiceResponse;

/**
 * 
 * Opprettet for CR195877
 *
 */
public class SimulerAP2011For2025Response extends ServiceResponse {
	private static final long serialVersionUID = -3736644050442067575L;
	
	private Pakkseddel pakkseddel;
	private BeregnAlderspensjon2011ForsteUttakResponse ap2011Response;
	
	public SimulerAP2011For2025Response() {
		super();
	}

	public SimulerAP2011For2025Response(Pakkseddel pakkseddel,
			BeregnAlderspensjon2011ForsteUttakResponse ap2011Response) {
		super();
		this.pakkseddel = pakkseddel;
		this.ap2011Response = ap2011Response;
	}

	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}

	public BeregnAlderspensjon2011ForsteUttakResponse getAp2011Response() {
		return ap2011Response;
	}

	public void setAp2011Response(
			BeregnAlderspensjon2011ForsteUttakResponse ap2011Response) {
		this.ap2011Response = ap2011Response;
	}
	
}
