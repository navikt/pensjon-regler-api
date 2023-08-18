package no.nav.pensjon.regler.to;

import java.util.Vector;

import no.nav.pensjon.regler.domain.afpoppgjor.AFPetteroppgjor;

public class BeregnAfpEtteroppgjorResponse extends ServiceResponse {

	private static final long serialVersionUID = 6349688055318090330L;

	private Vector<AFPetteroppgjor> afpEtteroppgjorListe = new Vector<AFPetteroppgjor>();

	public BeregnAfpEtteroppgjorResponse(Vector<AFPetteroppgjor> afpEtteroppgjorListe) {
		super();
		this.afpEtteroppgjorListe = afpEtteroppgjorListe;
	}

	public BeregnAfpEtteroppgjorResponse() {
		super();
	}

	public Vector<AFPetteroppgjor> getAfpEtteroppgjorListe() {
		return afpEtteroppgjorListe;
	}

	/**
	 * Read only property for afpEtteroppgjorListe
	 * @return array of AFPetteroppgjor
	 */
	public AFPetteroppgjor[] getAfpEtteroppgjorListeAsArray() {
		return (afpEtteroppgjorListe != null ? this.afpEtteroppgjorListe.toArray(new AFPetteroppgjor[this.afpEtteroppgjorListe.size()]) : new AFPetteroppgjor[0]);
	}
	
	public void setAfpEtteroppgjorListe(
			Vector<AFPetteroppgjor> afpEtteroppgjorListe) {
		this.afpEtteroppgjorListe = afpEtteroppgjorListe;
	}

}
