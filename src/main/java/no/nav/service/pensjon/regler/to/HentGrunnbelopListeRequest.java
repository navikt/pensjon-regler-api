package no.nav.service.pensjon.regler.to;

import java.util.Date;


public class HentGrunnbelopListeRequest extends ServiceRequest{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2005301062763802782L;
	private Date fom;
	private Date tom;
	
	public HentGrunnbelopListeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HentGrunnbelopListeRequest(Date fom, Date tom) {
		super();
		this.fom = fom;
		this.tom = tom;
	}
	public Date getFom() {
		return fom;
	}
	public void setFom(Date fom) {
		this.fom = fom;
	}
	public Date getTom() {
		return tom;
	}
	public void setTom(Date tom) {
		this.tom = tom;
	}
	
}
