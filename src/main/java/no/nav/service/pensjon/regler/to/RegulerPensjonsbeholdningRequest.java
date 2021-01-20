package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Date;

import no.nav.domain.pensjon.regler.grunnlag.PersonPensjonsbeholdning;

public class RegulerPensjonsbeholdningRequest extends ServiceRequest  {
	private static final long serialVersionUID = -1436468885395731897L;

	private Date virkFom;
	private ArrayList<PersonPensjonsbeholdning> beregningsgrunnlagForPensjonsbeholdning;

	public RegulerPensjonsbeholdningRequest() {
		super();
		beregningsgrunnlagForPensjonsbeholdning = new ArrayList<PersonPensjonsbeholdning>();
	}

	public RegulerPensjonsbeholdningRequest(
			Date virkFom,
			ArrayList<PersonPensjonsbeholdning> beregningsgrunnlagForPensjonsbeholdning) {
		this();
		this.virkFom = virkFom;
		this.beregningsgrunnlagForPensjonsbeholdning = beregningsgrunnlagForPensjonsbeholdning;
	}

	public Date getVirkFom() {
		return virkFom;
	}

	public void setVirkFom(Date virkFom) {
		this.virkFom = virkFom;
	}

	public ArrayList<PersonPensjonsbeholdning> getBeregningsgrunnlagForPensjonsbeholdning() {
		return beregningsgrunnlagForPensjonsbeholdning;
	}

	public void setBeregningsgrunnlagForPensjonsbeholdning(
			ArrayList<PersonPensjonsbeholdning> beregningsgrunnlagForPensjonsbeholdning) {
		this.beregningsgrunnlagForPensjonsbeholdning = beregningsgrunnlagForPensjonsbeholdning;
	}
	
	public PersonPensjonsbeholdning[] getBeregningsgrunnlagForPensjonsbeholdningAsArray() {
		return (beregningsgrunnlagForPensjonsbeholdning != null ? beregningsgrunnlagForPensjonsbeholdning.toArray(new PersonPensjonsbeholdning[beregningsgrunnlagForPensjonsbeholdning.size()]) : new PersonPensjonsbeholdning[0]);
	}
}
