package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.grunnlag.PersonPensjonsbeholdning;
import no.stelvio.common.transferobject.ServiceResponse;

public class RegulerPensjonsbeholdningResponse extends ServiceResponse  {
	private static final long serialVersionUID = 1245764083517519824L;
	
	private Pakkseddel pakkseddel;
	private ArrayList<PersonPensjonsbeholdning> regulertBeregningsgrunnlagForPensjonsbeholdning;

	public RegulerPensjonsbeholdningResponse() {
		super();
		regulertBeregningsgrunnlagForPensjonsbeholdning = new ArrayList<PersonPensjonsbeholdning>();
	}

	public RegulerPensjonsbeholdningResponse(
			Pakkseddel pakkseddel,
			ArrayList<PersonPensjonsbeholdning> regulertBeregningsgrunnlagForPensjonsbeholdning) {
		this();
		this.pakkseddel = pakkseddel;
		this.regulertBeregningsgrunnlagForPensjonsbeholdning = regulertBeregningsgrunnlagForPensjonsbeholdning;
	}

	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}

	public ArrayList<PersonPensjonsbeholdning> getRegulertBeregningsgrunnlagForPensjonsbeholdning() {
		return regulertBeregningsgrunnlagForPensjonsbeholdning;
	}

	public void setRegulertBeregningsgrunnlagForPensjonsbeholdning(
			ArrayList<PersonPensjonsbeholdning> regulertBeregningsgrunnlagForPensjonsbeholdning) {
		this.regulertBeregningsgrunnlagForPensjonsbeholdning = regulertBeregningsgrunnlagForPensjonsbeholdning;
	}
	
	public PersonPensjonsbeholdning[] getRegulertBeregningsgrunnlagForPensjonsbeholdningAsArray() {
		return (regulertBeregningsgrunnlagForPensjonsbeholdning != null ? regulertBeregningsgrunnlagForPensjonsbeholdning.toArray(new PersonPensjonsbeholdning[regulertBeregningsgrunnlagForPensjonsbeholdning.size()]) : new PersonPensjonsbeholdning[0]);
	}
	
}
