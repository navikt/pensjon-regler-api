package no.nav.service.pensjon.regler.to;

import java.util.Vector;

import no.nav.domain.pensjon.regler.grunnlag.PersonOpptjeningsgrunnlag;
import no.stelvio.common.transferobject.ServiceResponse;

public class BeregnPoengtallBatchResponse extends ServiceResponse{

	private static final long serialVersionUID = -6736371051640111785L;
	
	private Vector<PersonOpptjeningsgrunnlag> personOpptjeningsgrunnlagListe = new Vector<PersonOpptjeningsgrunnlag>();

	public BeregnPoengtallBatchResponse() {
		super();
	}
	public BeregnPoengtallBatchResponse(Vector<PersonOpptjeningsgrunnlag> personOpptjeningsgrunnlagListe) {
		super();
		this.personOpptjeningsgrunnlagListe = personOpptjeningsgrunnlagListe;
	}
	public Vector<PersonOpptjeningsgrunnlag> getPersonOpptjeningsgrunnlagListe() {
		return personOpptjeningsgrunnlagListe;
	}

	/**
	 * Read only property for personOpptjeningsgrunnlagListe as array
	 * @return array of PersonOpptjeningsgrunnlag
	 */
	public PersonOpptjeningsgrunnlag[] getPersonOpptjeningsgrunnlagListeAsArray() {
		return (personOpptjeningsgrunnlagListe != null ? this.personOpptjeningsgrunnlagListe.toArray(new PersonOpptjeningsgrunnlag[this.personOpptjeningsgrunnlagListe.size()]) : new PersonOpptjeningsgrunnlag[0]);
	}
	
	public void setPersonOpptjeningsgrunnlagListe(
			Vector<PersonOpptjeningsgrunnlag> personOpptjeningsgrunnlagListe) {
		this.personOpptjeningsgrunnlagListe = personOpptjeningsgrunnlagListe;
	}




}
