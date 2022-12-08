package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsResultatAlderspensjon2025;

public class BeregnAlderspensjon2025ForsteUttakResponse extends ServiceResponse {

	private BeregningsResultatAlderspensjon2025 beregningsResultat;
	private BeregningsResultatAlderspensjon2025 beregningsResultatTilRevurdering;
	private Pakkseddel pakkseddel;

}
