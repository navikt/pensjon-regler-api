package no.nav.pensjon.regler.to;

import java.util.Vector;

import no.nav.pensjon.regler.domain.gomregning.KravFaktoromregningResultat;

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

	public void setBeregningerFaktoromregningResultatListe(
			Vector<KravFaktoromregningResultat> beregningerFaktoromregningResultatListe) {
		this.kravFaktoromregningResultatListe = beregningerFaktoromregningResultatListe;
	}

}
