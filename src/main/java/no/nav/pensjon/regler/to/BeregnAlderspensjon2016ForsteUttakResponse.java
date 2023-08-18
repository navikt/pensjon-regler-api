package no.nav.pensjon.regler.to;

import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAlderspensjon2016;

public class BeregnAlderspensjon2016ForsteUttakResponse extends ServiceResponse {
	private static final long serialVersionUID = -6889834510953038946L;
	private BeregningsResultatAlderspensjon2016 beregningsResultat;
	private BeregningsResultatAlderspensjon2016 beregningsresultatTilRevurdering;
	private Pakkseddel pakkseddel;

	public BeregnAlderspensjon2016ForsteUttakResponse() {
		super();
	}
	
	public void setBeregningsResultat(BeregningsResultatAlderspensjon2016 beregningsResultat) {
		this.beregningsResultat = beregningsResultat;
	}
	
	public BeregningsResultatAlderspensjon2016 getBeregningsResultat() {
		//return beregningsResultat;
		return beregningsResultat;
	}
	
	public void setBeregningsresultatTilRevurdering(
			BeregningsResultatAlderspensjon2016 beregningsresultatTilRevurdering) {
		this.beregningsresultatTilRevurdering = beregningsresultatTilRevurdering;
	}

	public BeregningsResultatAlderspensjon2016 getBeregningsresultatTilRevurdering() {
		return beregningsresultatTilRevurdering;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}
	
	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}
}
