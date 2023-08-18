package no.nav.pensjon.regler.to;

import java.util.Date;


/**
 * Dataoverføringsobjekt, inndata, for tjenesten beregnMinstepensjon.
 */
public class BeregnMinstepensjonRequest extends ServiceRequest{

	private static final long serialVersionUID = -7602028289437378430L;
	private Date virk;
	
	public BeregnMinstepensjonRequest() {
		super();
	}

	public BeregnMinstepensjonRequest(Date virk) {
		this.virk = virk;
	}

	public Date getVirk() {
		return virk;
	}

	public void setVirk(Date virk) {
		this.virk = virk;
	}


}
