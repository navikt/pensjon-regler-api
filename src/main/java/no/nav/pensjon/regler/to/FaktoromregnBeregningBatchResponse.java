package no.nav.pensjon.regler.to;

import java.util.Vector;

import no.nav.pensjon.regler.domain.gomregning.BeregningerFaktoromregningResultat;

public class FaktoromregnBeregningBatchResponse extends ServiceResponse {
	private static final long serialVersionUID = -2759571563519787907L;

	private Vector<BeregningerFaktoromregningResultat> beregningerFaktoromregningResultatListe = new Vector<BeregningerFaktoromregningResultat>();

	public FaktoromregnBeregningBatchResponse() {
		super();
	}
	public FaktoromregnBeregningBatchResponse(Vector<BeregningerFaktoromregningResultat> res) {
		super();
		this.beregningerFaktoromregningResultatListe = res;
	}

	public Vector<BeregningerFaktoromregningResultat> getBeregningerFaktoromregningResultatListe() {
		return beregningerFaktoromregningResultatListe;
	}

	public void setBeregningerFaktoromregningResultatListe(
			Vector<BeregningerFaktoromregningResultat> beregningerFaktoromregningResultatListe) {
		this.beregningerFaktoromregningResultatListe = beregningerFaktoromregningResultatListe;
	}

}
