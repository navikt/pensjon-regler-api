package no.nav.pensjon.regler.to;

import java.util.Vector;

import no.nav.pensjon.regler.domain.grunnlag.PersonOpptjeningsgrunnlag;

public class BeregnPoengtallBatchRequest extends ServiceRequest{

	private static final long serialVersionUID = -7536363544487478598L;
	
	private Vector<PersonOpptjeningsgrunnlag> personOpptjeningsgrunnlagListe = new Vector<PersonOpptjeningsgrunnlag>();

	public BeregnPoengtallBatchRequest() {
		super();
	}
	public BeregnPoengtallBatchRequest(Vector<PersonOpptjeningsgrunnlag> personOpptjeningsgrunnlagListe) {
		super();
		this.personOpptjeningsgrunnlagListe = personOpptjeningsgrunnlagListe;
	}
	public Vector<PersonOpptjeningsgrunnlag> getPersonOpptjeningsgrunnlagliste() {
		return personOpptjeningsgrunnlagListe;
	}


	public void setPersonOpptjeningsgrunnlagliste(Vector<PersonOpptjeningsgrunnlag> personOpptjeningsgrunnlagListe) {
		this.personOpptjeningsgrunnlagListe = personOpptjeningsgrunnlagListe;
	}

}
