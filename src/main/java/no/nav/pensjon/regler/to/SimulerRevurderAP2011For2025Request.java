package no.nav.pensjon.regler.to;

import no.nav.pensjon.regler.domain.grunnlag.DelingstallUtvalg;
import no.nav.pensjon.regler.domain.grunnlag.GarantitilleggsbeholdningGrunnlag;

/**
 * 
 * Opprettet for CR195877
 *
 */
public class SimulerRevurderAP2011For2025Request extends ServiceRequest {
	private static final long serialVersionUID = -128140760015306769L;
	
	private RevurderingAlderspensjon2011Request ap2011Request;
	private GarantitilleggsbeholdningGrunnlag garantitilleggsbeholdningGrunnlag;
	private DelingstallUtvalg delingstallUtvalg;

	public SimulerRevurderAP2011For2025Request() {
	    super();
	}

	public SimulerRevurderAP2011For2025Request(RevurderingAlderspensjon2011Request ap2011Request,
			DelingstallUtvalg delingstallUtvalg, 
			GarantitilleggsbeholdningGrunnlag garantitilleggsbeholdningGrunnlag) {
		this.ap2011Request = ap2011Request;
		this.delingstallUtvalg = delingstallUtvalg;
		this.garantitilleggsbeholdningGrunnlag = garantitilleggsbeholdningGrunnlag;
	}

	public RevurderingAlderspensjon2011Request getAp2011Request() {
		return ap2011Request;
	}

	public void setAp2011Request(
			RevurderingAlderspensjon2011Request ap2011Request) {
		this.ap2011Request = ap2011Request;
	}

	public GarantitilleggsbeholdningGrunnlag getGarantitilleggsbeholdningGrunnlag() {
		return garantitilleggsbeholdningGrunnlag;
	}

	public void setGarantitilleggsbeholdningGrunnlag(
			GarantitilleggsbeholdningGrunnlag garantitilleggsbeholdningGrunnlag) {
		this.garantitilleggsbeholdningGrunnlag = garantitilleggsbeholdningGrunnlag;
	}

	public DelingstallUtvalg getDelingstallUtvalg() {
		return delingstallUtvalg;
	}

	public void setDelingstallUtvalg(DelingstallUtvalg delingstallUtvalg) {
		this.delingstallUtvalg = delingstallUtvalg;
	}
	
}
