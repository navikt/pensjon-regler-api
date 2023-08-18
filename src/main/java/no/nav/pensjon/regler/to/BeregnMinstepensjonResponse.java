package no.nav.pensjon.regler.to;

/**
 * Dataoverføringsobjekt, returdata, for tjenesten beregnMinstepensjon.
 *
 */
public class BeregnMinstepensjonResponse extends ServiceResponse{

	private static final long serialVersionUID = 7909042807483897485L;

	private long belop;
	public BeregnMinstepensjonResponse(long belop) {
		super();
		this.belop = belop;
	}
	public BeregnMinstepensjonResponse() {
		super();
	}
	public long getBelop() {
		return belop;
	}
	public void setBelop(long belop) {
		this.belop = belop;
	}

	
}
