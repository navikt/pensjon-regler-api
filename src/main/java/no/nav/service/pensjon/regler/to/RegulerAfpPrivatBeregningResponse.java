package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsResultatAfpPrivat;

public class RegulerAfpPrivatBeregningResponse extends ServiceResponse {
	private static final long serialVersionUID = 4960200642448567870L;
	
	private BeregningsResultatAfpPrivat beregningsResultat;
	private Pakkseddel pakkseddel;
	
	public RegulerAfpPrivatBeregningResponse() {
		super();
	}

	public BeregningsResultatAfpPrivat getBeregningsResultat() {
		return beregningsResultat;
	}

	public void setBeregningsResultat(BeregningsResultatAfpPrivat beregningsResultat) {
		this.beregningsResultat = beregningsResultat;
	}

	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}
	
}
