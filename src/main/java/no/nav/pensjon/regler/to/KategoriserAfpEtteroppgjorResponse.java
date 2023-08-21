package no.nav.pensjon.regler.to;

import java.util.Vector;

import no.nav.pensjon.regler.domain.afpoppgjor.AfpEtteroppgjorKategori;

public class KategoriserAfpEtteroppgjorResponse extends ServiceResponse {

	private static final long serialVersionUID = -1033413023105283440L;
	
	private Vector<AfpEtteroppgjorKategori> afpEtteroppgjorKategoriListe = new Vector<AfpEtteroppgjorKategori>();

	public KategoriserAfpEtteroppgjorResponse(Vector<AfpEtteroppgjorKategori> afpEtteroppgjorKategoriListe) {
		super();
		this.afpEtteroppgjorKategoriListe = afpEtteroppgjorKategoriListe;
	}

	public KategoriserAfpEtteroppgjorResponse() {
		super();
	}

	public Vector<AfpEtteroppgjorKategori> getAfpEtteroppgjorKategoriListe() {
		return afpEtteroppgjorKategoriListe;
	}

	public void setAfpEtteroppgjorKategoriListe(
			Vector<AfpEtteroppgjorKategori> afpEtteroppgjorKategoriListe) {
		this.afpEtteroppgjorKategoriListe = afpEtteroppgjorKategoriListe;
	}

}
