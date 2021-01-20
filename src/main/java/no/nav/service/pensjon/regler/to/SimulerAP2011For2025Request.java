package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.grunnlag.DelingstallUtvalg;
import no.nav.domain.pensjon.regler.grunnlag.GarantitilleggsbeholdningGrunnlag;

/**
 * 
 * Opprettet for CR195877
 *
 */
public class SimulerAP2011For2025Request extends ServiceRequest {
	private static final long serialVersionUID = 6342900985292786332L;
	
	private BeregnAlderspensjon2011ForsteUttakRequest ap2011Request;
	private GarantitilleggsbeholdningGrunnlag garantitilleggsbeholdningGrunnlag;
	private DelingstallUtvalg delingstallUtvalg;

	public SimulerAP2011For2025Request() {
	    super();
	}

	public SimulerAP2011For2025Request(BeregnAlderspensjon2011ForsteUttakRequest ap2011Request,
			DelingstallUtvalg delingstallUtvalg, 
			GarantitilleggsbeholdningGrunnlag garantitilleggsbeholdningGrunnlag) {
		this.ap2011Request = ap2011Request;
		this.delingstallUtvalg = delingstallUtvalg;
		this.garantitilleggsbeholdningGrunnlag = garantitilleggsbeholdningGrunnlag;
	}

	public BeregnAlderspensjon2011ForsteUttakRequest getAp2011Request() {
		return ap2011Request;
	}

	public void setAp2011Request(
			BeregnAlderspensjon2011ForsteUttakRequest ap2011Request) {
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
