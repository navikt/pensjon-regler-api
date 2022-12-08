package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsResultatAlderspensjon2011;
import no.nav.domain.pensjon.regler.beregning2011.PensjonUnderUtbetaling;
/**
 * 
 * @author Christian Arnesen
 *
 */
public class KonverterAP1967TilAP2011Response extends ServiceResponse{


	private BeregningsResultatAlderspensjon2011 revurdertBeregningsresultat;

	private Pakkseddel pakkseddel = new Pakkseddel(true, true);

	

}
