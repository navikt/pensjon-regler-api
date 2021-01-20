package no.nav.service.pensjon.regler.to;


import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsResultatAlderspensjon2011;

public class BeregnAlderspensjon2011ForsteUttakResponse extends ServiceResponse {
	private static final long serialVersionUID = -6889834510953038946L;
	private BeregningsResultatAlderspensjon2011 beregningsResultat;
	
	/* Det overordnete objektet som inneholder hele resultat som skal brukes til revurdering.
	 * Kun utfylt dersom en eksportberegning har blitt utfort. ifm. CR162089*/
	private BeregningsResultatAlderspensjon2011 beregningsresultatTilRevurdering;
	
	private Pakkseddel pakkseddel;

	public BeregnAlderspensjon2011ForsteUttakResponse() {
		super();
	}
	
	public void setBeregningsResultat(BeregningsResultatAlderspensjon2011 beregningsResultat) {
		this.beregningsResultat = beregningsResultat;
	}
	
	public BeregningsResultatAlderspensjon2011 getBeregningsResultat() {
		return beregningsResultat;
	}
	
	public BeregningsResultatAlderspensjon2011 getBeregningsresultatTilRevurdering() {
		return beregningsresultatTilRevurdering;
	}

	public void setBeregningsresultatTilRevurdering(
			BeregningsResultatAlderspensjon2011 beregningsresultatTilRevurdering) {
		this.beregningsresultatTilRevurdering = beregningsresultatTilRevurdering;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}
	
	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}
}
