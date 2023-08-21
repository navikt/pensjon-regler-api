 package no.nav.pensjon.regler.to;

import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAlderspensjon2011;

public class BeregnOvergangskullResponse extends ServiceResponse {
	private static final long serialVersionUID = 4594442687428453448L;

	private BeregningsResultatAlderspensjon2011 revurdertBeregningsResultat;
	private Pakkseddel pakkseddel;
	
	public BeregnOvergangskullResponse() {
		super();
	}
	public BeregnOvergangskullResponse(BeregningsResultatAlderspensjon2011 revurdertBeregningsResultat, Pakkseddel pakkseddel) {
		super();
		this.revurdertBeregningsResultat = revurdertBeregningsResultat;
		this.pakkseddel = pakkseddel;
	}
	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}
	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}
	public BeregningsResultatAlderspensjon2011 getRevurdertBeregningsResultat() {
		//return revurdertBeregningsResultat;
		return revurdertBeregningsResultat;
	}
	public void setRevurdertBeregningsResultat(
			BeregningsResultatAlderspensjon2011 revurdertBeregningsResultat) {
		this.revurdertBeregningsResultat = revurdertBeregningsResultat;
	}
	
}
