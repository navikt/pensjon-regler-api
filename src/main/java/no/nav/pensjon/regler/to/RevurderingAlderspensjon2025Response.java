package no.nav.pensjon.regler.to;

import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAlderspensjon2025;

public class RevurderingAlderspensjon2025Response extends ServiceResponse {

	private static final long serialVersionUID = 8319245242723320919L;

	private BeregningsResultatAlderspensjon2025 revurdertBeregningsResultat;
	private BeregningsResultatAlderspensjon2025 beregningsresultatTilRevurdering;
	
	private Pakkseddel pakkseddel;
	
	public RevurderingAlderspensjon2025Response() {
		super();
	}
	public RevurderingAlderspensjon2025Response(BeregningsResultatAlderspensjon2025 revurdertBeregningsResultat, Pakkseddel pakkseddel) {
		super();
		this.revurdertBeregningsResultat = revurdertBeregningsResultat;
		this.pakkseddel = pakkseddel;
	}
	
	public BeregningsResultatAlderspensjon2025 getRevurdertBeregningsResultat() {
		return revurdertBeregningsResultat;
	}
	public void setRevurdertBeregningsResultat(
			BeregningsResultatAlderspensjon2025 revurdertBeregningsResultat) {
		this.revurdertBeregningsResultat = revurdertBeregningsResultat;
	}
	public BeregningsResultatAlderspensjon2025 getBeregningsresultatTilRevurdering() {
		return beregningsresultatTilRevurdering;
	}
	public void setBeregningsresultatTilRevurdering(
			BeregningsResultatAlderspensjon2025 beregningsresultatTilRevurdering) {
		this.beregningsresultatTilRevurdering = beregningsresultatTilRevurdering;
	}
	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}
	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}
	
	
	
}
