package no.nav.service.pensjon.regler.to;

import java.util.Vector;

import no.nav.domain.pensjon.regler.gomregning.BeregningerFaktoromregningResultat;

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

	/**
	 * Read only property for beregningerFaktoromregningResultatListe as array
	 * @return array of BeregningerFaktoromregningResultat
	 */
	public BeregningerFaktoromregningResultat[] getBeregningerFaktoromregningResultatListeAsArray() {
		return (beregningerFaktoromregningResultatListe != null ? this.beregningerFaktoromregningResultatListe.toArray(new BeregningerFaktoromregningResultat[this.beregningerFaktoromregningResultatListe.size()]) : new BeregningerFaktoromregningResultat[0]);
	}
	
	public void setBeregningerFaktoromregningResultatListe(
			Vector<BeregningerFaktoromregningResultat> beregningerFaktoromregningResultatListe) {
		this.beregningerFaktoromregningResultatListe = beregningerFaktoromregningResultatListe;
	}

}
