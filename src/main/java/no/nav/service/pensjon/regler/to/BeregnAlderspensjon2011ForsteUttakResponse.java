package no.nav.service.pensjon.regler.to;


import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsResultatAlderspensjon2011;

public class BeregnAlderspensjon2011ForsteUttakResponse extends ServiceResponse {
	private BeregningsResultatAlderspensjon2011 beregningsResultat;
	
	/* Det overordnete objektet som inneholder hele resultat som skal brukes til revurdering.
	 * Kun utfylt dersom en eksportberegning har blitt utfort. ifm. CR162089*/
	private BeregningsResultatAlderspensjon2011 beregningsresultatTilRevurdering;
	
	private Pakkseddel pakkseddel;

}
