package no.nav.service.pensjon.regler.to;

import java.util.Vector;

import no.nav.domain.pensjon.regler.afpoppgjor.AFPEtteroppgjorgrunnlag;

public class BeregnAfpEtteroppgjorRequest  extends ServiceRequest {

	private static final long serialVersionUID = 7881618280836071282L;

	private Vector<AFPEtteroppgjorgrunnlag> afpEtteroppgjorgrunnlagListe = new Vector<AFPEtteroppgjorgrunnlag>();

	public BeregnAfpEtteroppgjorRequest(Vector<AFPEtteroppgjorgrunnlag> afpEtteroppgjorgrunnlagListe) {
		super();
		this.afpEtteroppgjorgrunnlagListe = afpEtteroppgjorgrunnlagListe;
	}
	public BeregnAfpEtteroppgjorRequest() {
		super();
	}
	public Vector<AFPEtteroppgjorgrunnlag> getAfpEtteroppgjorgrunnlagListe() {
		return afpEtteroppgjorgrunnlagListe;
	}

	public void setAfpEtteroppgjorgrunnlagListe(
			Vector<AFPEtteroppgjorgrunnlag> afpEtteroppgjorgrunnlagListe) {
		this.afpEtteroppgjorgrunnlagListe = afpEtteroppgjorgrunnlagListe;
	}

	/**
	 * Read only property for afpEtteroppgjorgrunnlagListe as array
	 * @return array of AFPEtteroppgjorgrunnlag
	 */
	public AFPEtteroppgjorgrunnlag[] getAfpEtteroppgjorgrunnlagListeAsArray(){
		return (afpEtteroppgjorgrunnlagListe != null ? afpEtteroppgjorgrunnlagListe.toArray(new AFPEtteroppgjorgrunnlag[afpEtteroppgjorgrunnlagListe.size()]) : new AFPEtteroppgjorgrunnlag[0]);
	}
}
