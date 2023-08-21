package no.nav.pensjon.regler.to;

import java.util.List;
import java.util.Vector;

import no.nav.pensjon.regler.domain.SatsResultat;


public class SatsResponse extends ServiceResponse{
	/**
	 *
	 */
	private static final long serialVersionUID = 5774531625770339127L;
	
	private List<SatsResultat> satsResultater = new Vector<SatsResultat>();

	public SatsResponse() {
		super();
	}

	public SatsResponse(List<SatsResultat> satsResultater) {
		super();
		this.satsResultater = satsResultater;
	}

	public List<SatsResultat> getSatsResultater() {
		return satsResultater;
	}
	public void setSatsResultater(List<SatsResultat> satsResultater) {
		this.satsResultater = satsResultater;
	}


}
