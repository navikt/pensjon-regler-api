 package no.nav.pensjon.regler.to;

import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAlderspensjon2016;

public class RevurderingOvergangskullResponse extends ServiceResponse {
	private static final long serialVersionUID = 9161949864613895672L;
	private BeregningsResultatAlderspensjon2016 revurdertBeregningsResultat;
	private Pakkseddel pakkseddel;
	
	public RevurderingOvergangskullResponse() {
		super();
	}
	public RevurderingOvergangskullResponse(BeregningsResultatAlderspensjon2016 revurdertBeregningsResultat, Pakkseddel pakkseddel) {
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
	public BeregningsResultatAlderspensjon2016 getRevurdertBeregningsResultat() {
		return revurdertBeregningsResultat;
	}
	public void setRevurdertBeregningsResultat(
			BeregningsResultatAlderspensjon2016 revurdertBeregningsResultat) {
		this.revurdertBeregningsResultat = revurdertBeregningsResultat;
	}
	
}
