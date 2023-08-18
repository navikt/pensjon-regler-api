package no.nav.pensjon.regler.to;

import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.beregning.Beregning;

public class RegulerBeregningResponse extends ServiceResponse {
	private static final long serialVersionUID = 4027093882295210815L;
	
	private Beregning regulertBeregning1967;
	private Pakkseddel pakkseddel;
	
	public RegulerBeregningResponse() {
		super();
	}

	public Beregning getRegulertBeregning1967() {
		return regulertBeregning1967;
	}

	public void setRegulertBeregning1967(Beregning regulertBeregning1967) {
		this.regulertBeregning1967 = regulertBeregning1967;
	}

	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}
	
}
