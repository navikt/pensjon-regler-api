package no.nav.service.pensjon.regler.to;

import java.util.List;
import java.util.Vector;

import no.nav.domain.pensjon.regler.VeietSatsResultat;


public class VeietSatsResponse extends ServiceResponse{

	private static final long serialVersionUID = -4188790763450940004L;

	private List<VeietSatsResultat> veietSatsResultater = new Vector<VeietSatsResultat>();

	public VeietSatsResponse() {
		super();
	}

	public VeietSatsResponse(List<VeietSatsResultat> veietSatsResultater) {
		super();
		this.veietSatsResultater = veietSatsResultater;
	}

	public List<VeietSatsResultat> getVeietSatsResultater() {
		return veietSatsResultater;
	}
	
	public VeietSatsResultat[] getVeietSatsResultaterAsArray() {
		return (veietSatsResultater != null ? this.veietSatsResultater.toArray(new VeietSatsResultat[this.veietSatsResultater.size()]) : new VeietSatsResultat[0]);
	}
	
	public void setVeietSatsResultater(List<VeietSatsResultat> satsResultater) {
		this.veietSatsResultater = satsResultater;
	}


}
