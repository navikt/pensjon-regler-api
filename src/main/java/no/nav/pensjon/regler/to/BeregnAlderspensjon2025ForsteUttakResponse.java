package no.nav.pensjon.regler.to;

import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAlderspensjon2025;

public class BeregnAlderspensjon2025ForsteUttakResponse extends ServiceResponse {

	private static final long serialVersionUID = 1275039502914650267L;
	private BeregningsResultatAlderspensjon2025 beregningsResultat;
	private BeregningsResultatAlderspensjon2025 beregningsResultatTilRevurdering;
	private Pakkseddel pakkseddel;

	public  BeregnAlderspensjon2025ForsteUttakResponse() {
		super();
	}

	
	public BeregnAlderspensjon2025ForsteUttakResponse(
			BeregningsResultatAlderspensjon2025 beregningsResultat,
			Pakkseddel pakkseddel) {
		super();
		this.beregningsResultat = beregningsResultat;
		this.pakkseddel = pakkseddel;
	}

	public BeregningsResultatAlderspensjon2025 getBeregningsResultat() {
		return beregningsResultat;
	}

	public void setBeregningsResultat(
			BeregningsResultatAlderspensjon2025 beregningsResultat) {
		this.beregningsResultat = beregningsResultat;
	}
	public BeregningsResultatAlderspensjon2025 getBeregningsResultatTilRevurdering() {
		return beregningsResultatTilRevurdering;
	}

	public void setBeregningsResultatTilRevurdering(
			BeregningsResultatAlderspensjon2025 beregningsResultatTilRevurdering) {
		this.beregningsResultatTilRevurdering = beregningsResultatTilRevurdering;
	}


	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}
	
	
}
