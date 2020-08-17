package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsResultatAlderspensjon2011;
import no.nav.domain.pensjon.regler.beregning2011.PensjonUnderUtbetaling;
import no.stelvio.common.transferobject.ServiceResponse;
/**
 * 
 * @author Christian Arnesen
 *
 */
public class KonverterAP1967TilAP2011Response extends ServiceResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4550748652004535067L;
	private BeregningsResultatAlderspensjon2011 revurdertBeregningsresultat;
	/**
	 * Pakkseddel for beregningene.
	 */
	private Pakkseddel pakkseddel = new Pakkseddel(true, true);
	
	
	

	public KonverterAP1967TilAP2011Response(BeregningsResultatAlderspensjon2011 revurdertBeregningsresultat, Pakkseddel pakkseddel) {
		super();
		this.revurdertBeregningsresultat = revurdertBeregningsresultat;
		this.pakkseddel = pakkseddel;
	}

	public KonverterAP1967TilAP2011Response(BeregningsResultatAlderspensjon2011 revurdertBeregningsresultat, PensjonUnderUtbetaling pensjonUnderUtbetaling) {
		super();
		this.revurdertBeregningsresultat = revurdertBeregningsresultat;
	}
	
	public KonverterAP1967TilAP2011Response() {
		super();
	}

	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}
	public BeregningsResultatAlderspensjon2011 getRevurdertBeregningsresultat() {
		return revurdertBeregningsresultat;
	}
	public void setRevurdertBeregningsresultat(
			BeregningsResultatAlderspensjon2011 revurdertBeregningsresultat) {
		this.revurdertBeregningsresultat = revurdertBeregningsresultat;
	}
	
	

}
