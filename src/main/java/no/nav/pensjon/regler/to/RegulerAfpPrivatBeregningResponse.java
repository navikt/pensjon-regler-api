package no.nav.pensjon.regler.to;

import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAfpPrivat;

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
