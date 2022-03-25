package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import no.nav.domain.pensjon.regler.VeietSatsResultat;


public class VeietSatsResponse extends ServiceResponse{

	private static final long serialVersionUID = -4188790763450940004L;

	private ArrayList<VeietSatsResultat> veietSatsResultater = new ArrayList<>();

	public VeietSatsResponse() {
		super();
	}

	public VeietSatsResponse(ArrayList<VeietSatsResultat> veietSatsResultater) {
		super();
		this.veietSatsResultater = veietSatsResultater;
	}

	public ArrayList<VeietSatsResultat> getVeietSatsResultater() {
		return veietSatsResultater;
	}
	
	public VeietSatsResultat[] getVeietSatsResultaterAsArray() {
		return (veietSatsResultater != null ? this.veietSatsResultater.toArray(new VeietSatsResultat[this.veietSatsResultater.size()]) : new VeietSatsResultat[0]);
	}
	
	public void setVeietSatsResultater(ArrayList<VeietSatsResultat> satsResultater) {
		this.veietSatsResultater = satsResultater;
	}


}
