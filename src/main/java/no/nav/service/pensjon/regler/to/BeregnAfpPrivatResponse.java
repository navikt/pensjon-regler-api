package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsResultatAfpPrivat;

public class BeregnAfpPrivatResponse extends ServiceResponse  {
	private static final long serialVersionUID = -3870329192207845501L;
	 
	private BeregningsResultatAfpPrivat beregningsResultatAfpPrivat;

	private Pakkseddel pakkseddel;
	
	public BeregnAfpPrivatResponse() {
		super();
	}

	public BeregnAfpPrivatResponse(BeregningsResultatAfpPrivat beregningsResultatAfpPrivat, Pakkseddel pakkseddel) {
		super();
		this.beregningsResultatAfpPrivat = beregningsResultatAfpPrivat;
		this.pakkseddel = pakkseddel; 
	}

	public BeregningsResultatAfpPrivat getBeregningsResultatAfpPrivat() {
		return beregningsResultatAfpPrivat;
	}

	public void setBeregningsResultatAfpPrivat(
			BeregningsResultatAfpPrivat beregningsResultatAfpPrivat) {
		this.beregningsResultatAfpPrivat = beregningsResultatAfpPrivat;
	}
	
	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}
	
	public Pakkseddel getPakkseddel(){
		return pakkseddel;
	}
	
}
