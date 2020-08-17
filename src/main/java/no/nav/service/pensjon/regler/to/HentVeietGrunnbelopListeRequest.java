package no.nav.service.pensjon.regler.to;

import no.stelvio.common.transferobject.ServiceRequest;

public class HentVeietGrunnbelopListeRequest extends ServiceRequest{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5805828615839859874L;
	private int fomArstall;
	private int tomArstall;
	
	
	public HentVeietGrunnbelopListeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public HentVeietGrunnbelopListeRequest(int fomArstall, int tomArstall) {
		super();
		this.fomArstall = fomArstall;
		this.tomArstall = tomArstall;
	}
	
	
	public int getFomArstall() {
		return fomArstall;
	}
	public void setFomArstall(int fomArstall) {
		this.fomArstall = fomArstall;
	}
	public int getTomArstall() {
		return tomArstall;
	}
	public void setTomArstall(int tomArstall) {
		this.tomArstall = tomArstall;
	}
	
}
