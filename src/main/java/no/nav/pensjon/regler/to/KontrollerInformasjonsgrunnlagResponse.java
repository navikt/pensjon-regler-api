package no.nav.pensjon.regler.to;

import java.util.List;
import java.util.Vector;

import no.nav.pensjon.regler.domain.Merknad;
import no.nav.pensjon.regler.domain.Pakkseddel;

public class KontrollerInformasjonsgrunnlagResponse extends ServiceResponse {

	private static final long serialVersionUID = -6381797778633101684L;

	private List<Merknad> merknadListe = new Vector<Merknad>();

	/**
	 * Pakkseddel for beregningene.
	 */
	private Pakkseddel pakkseddel = new Pakkseddel(true,true);

	public KontrollerInformasjonsgrunnlagResponse(List<Merknad> merknadListe) {
		super();
		this.merknadListe = merknadListe;
	}

	public KontrollerInformasjonsgrunnlagResponse() {
		super();
	}

	public List<Merknad> getMerknadListe() {
		return merknadListe;
	}

	/**
	 * Read only property for merknadListe as array
	 * @return array of Merknad
	 */
	public Merknad[] getMerknadListeAsArray() {
		return (merknadListe != null ? this.merknadListe.toArray(new Merknad[this.merknadListe.size()]) : new Merknad[0]);
	}
	
	public void setMerknadListe(List<Merknad> merknadListe) {
		this.merknadListe = merknadListe;
	}

	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}

}
