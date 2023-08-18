package no.nav.pensjon.regler.to;

import java.util.Date;

import no.nav.pensjon.regler.domain.grunnlag.Pensjonsbeholdning;
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag;
/**
 * Dataoverføringsobjekt for tjenesten beregnOpptjening.
 */
public class BeregnOpptjeningRequest extends ServiceRequest {

	private static final long serialVersionUID = 3003781537139014968L;

	private Date beholdningTom;
	private Persongrunnlag persongrunnlag;
	private Pensjonsbeholdning beholdning;
	
	public BeregnOpptjeningRequest() {
		super();
	}
	public BeregnOpptjeningRequest(Date beholdningTom, Persongrunnlag persongrunnlag, Pensjonsbeholdning beholdning) {
		super();
		this.beholdningTom = beholdningTom;
		this.persongrunnlag = persongrunnlag;
		this.beholdning = beholdning;
	}


	public Date getBeholdningTom() {
		return beholdningTom;
	}

	public void setBeholdningTom(Date beholdningTom) {
		this.beholdningTom = beholdningTom;
	}


	public Pensjonsbeholdning getBeholdning() {
		return beholdning;
	}
	public void setBeholdning(Pensjonsbeholdning beholdning) {
		this.beholdning = beholdning;
	}
	public Persongrunnlag getPersongrunnlag() {
		return persongrunnlag;
	}

	public void setPersongrunnlag(Persongrunnlag persongrunnlag) {
		this.persongrunnlag = persongrunnlag;
	}


}
