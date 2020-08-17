 package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsResultatAlderspensjon2016;
import no.stelvio.common.transferobject.ServiceResponse;

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
