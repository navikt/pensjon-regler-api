package no.nav.service.pensjon.regler.to;

import java.util.Vector;

import no.nav.domain.pensjon.regler.gomregning.KravFaktoromregningResultat;
import no.stelvio.common.transferobject.ServiceResponse;

public class FaktoromregnInntektBatchResponse extends ServiceResponse {

	private static final long serialVersionUID = 7113240386385631380L;
	
	private Vector<KravFaktoromregningResultat> kravFaktoromregningResultatListe = new Vector<KravFaktoromregningResultat>();

	public FaktoromregnInntektBatchResponse() {
		super();
	}
	public FaktoromregnInntektBatchResponse(Vector<KravFaktoromregningResultat> res) {
		super();
		this.kravFaktoromregningResultatListe = res;
	}

	public Vector<KravFaktoromregningResultat> getKravFaktoromregningResultatListe() {
		return kravFaktoromregningResultatListe;
	}

	/**
	 * Read only property for kravFaktoromregningResultatListe as array
	 * @return array of KravFaktoromregningResultat
	 */
	public KravFaktoromregningResultat[] getKravFaktoromregningResultatListeAsArray() {
		return (kravFaktoromregningResultatListe != null ? this.kravFaktoromregningResultatListe.toArray(new KravFaktoromregningResultat[this.kravFaktoromregningResultatListe.size()]) : new KravFaktoromregningResultat[0]);
	}
	
	public void setBeregningerFaktoromregningResultatListe(
			Vector<KravFaktoromregningResultat> beregningerFaktoromregningResultatListe) {
		this.kravFaktoromregningResultatListe = beregningerFaktoromregningResultatListe;
	}

}
