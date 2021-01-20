package no.nav.service.pensjon.regler.to;

import java.util.Vector;

import no.nav.domain.pensjon.regler.grunnlag.PersonOpptjeningsgrunnlag;

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

	/**
	 * Read only property for personOpptjeningsgrunnlagListe as array
	 * @return array of PersonOpptjeningsgrunnlag
	 */
	public PersonOpptjeningsgrunnlag[] getPersonOpptjeningsgrunnlaglisteAsArray() {
		return (personOpptjeningsgrunnlagListe != null ? this.personOpptjeningsgrunnlagListe.toArray(new PersonOpptjeningsgrunnlag[this.personOpptjeningsgrunnlagListe.size()]) : new PersonOpptjeningsgrunnlag[0]);
	}
	
	public void setPersonOpptjeningsgrunnlagliste(Vector<PersonOpptjeningsgrunnlag> personOpptjeningsgrunnlagListe) {
		this.personOpptjeningsgrunnlagListe = personOpptjeningsgrunnlagListe;
	}

}
