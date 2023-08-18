package no.nav.pensjon.regler.to;

import java.util.ArrayList;
import java.util.List;

import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.grunnlag.Pensjonsbeholdning;

public class BeregnOpptjeningResponse extends ServiceResponse {

	private static final long serialVersionUID = -5786548113638627228L;

	private ArrayList<Pensjonsbeholdning> beholdninger; 
	
	/**
	 * Pakkseddel for svaret.
	 */
	private Pakkseddel pakkseddel = new Pakkseddel(true, true);
	
	public BeregnOpptjeningResponse() {
		super();
		beholdninger = new ArrayList<Pensjonsbeholdning>();
	}

	public BeregnOpptjeningResponse(BeregnOpptjeningResponse br) {
		this();
		beholdninger = new ArrayList<Pensjonsbeholdning>();
		if (br.beholdninger != null)
			for (Pensjonsbeholdning b: br.beholdninger) {
				beholdninger.add(new Pensjonsbeholdning(b));
			}
	}
	
	public List<Pensjonsbeholdning> getBeholdninger() {
		return beholdninger;
	}

	public Pensjonsbeholdning[] getBeholdningerAsArray() {
		return (beholdninger != null ? beholdninger.toArray(new Pensjonsbeholdning[beholdninger.size()]) : new Pensjonsbeholdning[0]);	
	}
	
	public void setBeholdninger(List<Pensjonsbeholdning> beholdninger) {
		this.beholdninger = (ArrayList<Pensjonsbeholdning>) beholdninger;
	}

	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}

}
