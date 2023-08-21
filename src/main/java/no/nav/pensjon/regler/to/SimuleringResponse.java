package no.nav.pensjon.regler.to;

import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.simulering.Simuleringsresultat;

public class SimuleringResponse extends ServiceResponse{
	/**
	 *
	 */
	private static final long serialVersionUID = -4290957695559445244L;
	private Simuleringsresultat simuleringsResultat;
	private Pakkseddel pakkseddel;
	
	public SimuleringResponse() {
		super();
	}

	public SimuleringResponse(Simuleringsresultat simuleringsResultat, Pakkseddel pakkseddel) {
		super();
		this.simuleringsResultat = simuleringsResultat;
		this.pakkseddel = pakkseddel;
	}
	
	public SimuleringResponse(Simuleringsresultat simuleringsResultat) {
		super();
		this.simuleringsResultat = simuleringsResultat;
	}

	public Simuleringsresultat getSimuleringsResultat() {
		return simuleringsResultat;
	}

	public void setSimuleringsResultat(Simuleringsresultat simuleringsResultat) {
		this.simuleringsResultat = simuleringsResultat;
	}

	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}
}
