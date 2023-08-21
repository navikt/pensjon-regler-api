package no.nav.pensjon.regler.to;

import java.util.Vector;

import no.nav.pensjon.regler.domain.grunnlag.PersonOpptjeningsgrunnlag;

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


	public void setPersonOpptjeningsgrunnlagListe(
			Vector<PersonOpptjeningsgrunnlag> personOpptjeningsgrunnlagListe) {
		this.personOpptjeningsgrunnlagListe = personOpptjeningsgrunnlagListe;
	}




}
