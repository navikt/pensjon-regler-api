package no.nav.pensjon.regler.to;

import java.util.List;
import java.util.Vector;

import no.nav.pensjon.regler.domain.VeietSatsResultat;


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

	public void setVeietSatsResultater(List<VeietSatsResultat> satsResultater) {
		this.veietSatsResultater = satsResultater;
	}


}
