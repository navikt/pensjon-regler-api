package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsResultatAlderspensjon2016;

public class BeregnAlderspensjon2016ForsteUttakResponse extends ServiceResponse {
	private BeregningsResultatAlderspensjon2016 beregningsResultat;
	private BeregningsResultatAlderspensjon2016 beregningsresultatTilRevurdering;
	private Pakkseddel pakkseddel;

}
