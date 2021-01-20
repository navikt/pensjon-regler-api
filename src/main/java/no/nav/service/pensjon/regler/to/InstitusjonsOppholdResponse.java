package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.InstoppholdslisteResultat;

/**
 * Response objekt for tjenesten bestemInstitusjonsListe
 *
 */
public class InstitusjonsOppholdResponse extends ServiceResponse{


	private static final long serialVersionUID = -5169473351078567799L;
	
	private InstoppholdslisteResultat resultat;

	public InstitusjonsOppholdResponse(InstoppholdslisteResultat resultat) {
		super();
		this.resultat = resultat;
	}

	public InstitusjonsOppholdResponse() {
		super();
	}

	public InstoppholdslisteResultat getResultat() {
		return resultat;
	}

	public void setResultat(InstoppholdslisteResultat resultat) {
		this.resultat = resultat;
	}
	
}
