package no.nav.pensjon.regler.to;

import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAlderspensjon2016;

public class RevurderingAlderspensjon2016Response extends ServiceResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2371916581412213506L;

	private BeregningsResultatAlderspensjon2016 revurdertBeregningsResultat;
	private BeregningsResultatAlderspensjon2016 beregningsresultatTilRevurdering;
	private Pakkseddel pakkseddel;
	
	public RevurderingAlderspensjon2016Response() {
		super();
	}

	public RevurderingAlderspensjon2016Response(BeregningsResultatAlderspensjon2016 revurdertBeregningsResultat, Pakkseddel pakkseddel) {
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

	public void setBeregningsresultatTilRevurdering(
			BeregningsResultatAlderspensjon2016 beregningsresultatTilRevurdering) {
		this.beregningsresultatTilRevurdering = beregningsresultatTilRevurdering;
	}

	public BeregningsResultatAlderspensjon2016 getBeregningsresultatTilRevurdering() {
		return beregningsresultatTilRevurdering;
	}
	
}
