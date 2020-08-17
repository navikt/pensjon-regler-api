package no.nav.service.pensjon.regler.to;

import java.util.Date;

import no.stelvio.common.transferobject.ServiceRequest;

/**
 * @TODO - ferdigstill
 * @author utvikler
 *
 */
public class BeregnPoengrekkeRequest extends ServiceRequest{

	private static final long serialVersionUID = -5576069984784944296L;
	private Date fom;
	private Date tom;
	
	public BeregnPoengrekkeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BeregnPoengrekkeRequest(Date fom, Date tom ) {
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
