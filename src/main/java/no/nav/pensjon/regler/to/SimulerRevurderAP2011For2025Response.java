package no.nav.pensjon.regler.to;


import no.nav.pensjon.regler.domain.Pakkseddel;

/**
 * 
 * Opprettet for CR195877
 *
 */
public class SimulerRevurderAP2011For2025Response extends ServiceResponse {
	private static final long serialVersionUID = 8660720836533034216L;
	
	private Pakkseddel pakkseddel;
	private RevurderingAlderspensjon2011Response ap2011Response;
	
	public SimulerRevurderAP2011For2025Response() {
		super();
	}

	public SimulerRevurderAP2011For2025Response(Pakkseddel pakkseddel,
			RevurderingAlderspensjon2011Response ap2011Response) {
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

	public RevurderingAlderspensjon2011Response getAp2011Response() {
		return ap2011Response;
	}

	public void setAp2011Response(
			RevurderingAlderspensjon2011Response ap2011Response) {
		this.ap2011Response = ap2011Response;
	}
	
}
