package no.nav.service.pensjon.regler.to;

import java.util.List;
import java.util.Vector;

import no.nav.domain.pensjon.regler.SatsResultat;
import no.stelvio.common.transferobject.ServiceResponse;


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

	public SatsResultat[] getSatsResultaterAsArray() {
		return (satsResultater != null ? this.satsResultater.toArray(new SatsResultat[this.satsResultater.size()]) : new SatsResultat[0]);
	}
	
	public void setSatsResultater(List<SatsResultat> satsResultater) {
		this.satsResultater = satsResultater;
	}


}
