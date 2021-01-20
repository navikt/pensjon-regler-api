 package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsResultatAlderspensjon2011;

public class RevurderingAlderspensjon2011Response extends ServiceResponse {
	private static final long serialVersionUID = 4594442687428453448L;

	private BeregningsResultatAlderspensjon2011 revurdertBeregningsResultat;
	private BeregningsResultatAlderspensjon2011 beregningsresultatTilRevurdering;
	private Pakkseddel pakkseddel;
	
	public RevurderingAlderspensjon2011Response() {
		super();
	}
	public RevurderingAlderspensjon2011Response(BeregningsResultatAlderspensjon2011 revurdertBeregningsResultat,
			BeregningsResultatAlderspensjon2011 beregningsresultatTilRevurdering, Pakkseddel pakkseddel) {
		this.beregningsresultatTilRevurdering = beregningsresultatTilRevurdering;
		this.pakkseddel = pakkseddel;
	}
	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}
	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}
	public BeregningsResultatAlderspensjon2011 getRevurdertBeregningsResultat() {
		return revurdertBeregningsResultat;
	}
	public void setRevurdertBeregningsResultat(
			BeregningsResultatAlderspensjon2011 revurdertBeregningsResultat) {
		this.revurdertBeregningsResultat = revurdertBeregningsResultat;
	}
	public BeregningsResultatAlderspensjon2011 getberegningsresultatTilRevurdering() {
		//return beregningsresultatTilRevurdering;
		return beregningsresultatTilRevurdering;
	}
	public void setberegningsresultatTilRevurdering(
			BeregningsResultatAlderspensjon2011 beregningsresultatTilRevurdering) {
		this.beregningsresultatTilRevurdering = beregningsresultatTilRevurdering;
	}
	
}
