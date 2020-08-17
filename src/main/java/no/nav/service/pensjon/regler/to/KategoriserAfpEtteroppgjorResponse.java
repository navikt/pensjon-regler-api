package no.nav.service.pensjon.regler.to;

import java.util.Vector;

import no.nav.domain.pensjon.regler.afpoppgjor.AfpEtteroppgjorKategori;
import no.stelvio.common.transferobject.ServiceResponse;

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

	/**
	 * Read only property for afpEtteroppgjorKategoriListe as array
	 * @return array of AfpEtteroppgjorKategori
	 */
	public AfpEtteroppgjorKategori[] getAfpEtteroppgjorKategoriListeAsArray() {
		return (afpEtteroppgjorKategoriListe != null ? this.afpEtteroppgjorKategoriListe.toArray(new AfpEtteroppgjorKategori[this.afpEtteroppgjorKategoriListe.size()]) : new AfpEtteroppgjorKategori[0]);
	}
	
	public void setAfpEtteroppgjorKategoriListe(
			Vector<AfpEtteroppgjorKategori> afpEtteroppgjorKategoriListe) {
		this.afpEtteroppgjorKategoriListe = afpEtteroppgjorKategoriListe;
	}

}
