package no.nav.service.pensjon.regler.to;

import java.util.Date;
import java.util.Vector;

import no.nav.domain.pensjon.regler.gomregning.BeregningerTilFaktoromregningGrunnlag;

public class FaktoromregnBeregningBatchRequest  extends ServiceRequest {

	private static final long serialVersionUID = 756697222064890998L;
	private Date gammelGGjaldtDato;
	private Date nyGOmregnFraDato;
	private Vector<BeregningerTilFaktoromregningGrunnlag> beregningerTilFaktoromregningGrunnlagListe = new Vector<BeregningerTilFaktoromregningGrunnlag>();

	public FaktoromregnBeregningBatchRequest(Date gammelGGjaldtDato, Date nyGOmregnFraDato, Vector<BeregningerTilFaktoromregningGrunnlag> beregningerTilFaktoromregningGrunnlagListe) {
		super();
		this.gammelGGjaldtDato = gammelGGjaldtDato;
		this.nyGOmregnFraDato = nyGOmregnFraDato;
		this.beregningerTilFaktoromregningGrunnlagListe = beregningerTilFaktoromregningGrunnlagListe;
	}
	public FaktoromregnBeregningBatchRequest() {
		super();
		beregningerTilFaktoromregningGrunnlagListe = new Vector<BeregningerTilFaktoromregningGrunnlag>();
	}
	public Vector<BeregningerTilFaktoromregningGrunnlag> getBeregningerTilFaktoromregningGrunnlagListe() {
		return beregningerTilFaktoromregningGrunnlagListe;
	}
	
	/**
	 * Read only property for beregningerTilFaktoromregningGrunnlagListe as array
	 * @return array of BeregningerTilFaktoromregningGrunnlag
	 */
	public BeregningerTilFaktoromregningGrunnlag[] getBeregningerTilFaktoromregningGrunnlagListeAsArray() {
		return (beregningerTilFaktoromregningGrunnlagListe != null ? this.beregningerTilFaktoromregningGrunnlagListe.toArray(new BeregningerTilFaktoromregningGrunnlag[this.beregningerTilFaktoromregningGrunnlagListe.size()]) : new BeregningerTilFaktoromregningGrunnlag[0]);
	}
	
	public void setBeregningerTilFaktoromregningGrunnlagListe(
			Vector<BeregningerTilFaktoromregningGrunnlag> beregningerTilFaktoromregningGrunnlagListe) {
		this.beregningerTilFaktoromregningGrunnlagListe = beregningerTilFaktoromregningGrunnlagListe;
	}
	public Date getGammelGGjaldtDato() {
		return gammelGGjaldtDato;
	}
	public void setGammelGGjaldtDato(Date gammelGGjaldtDato) {
		this.gammelGGjaldtDato = gammelGGjaldtDato;
	}
	public Date getNyGOmregnFraDato() {
		return nyGOmregnFraDato;
	}
	public void setNyGOmregnFraDato(Date nyGOmregnFraDato) {
		this.nyGOmregnFraDato = nyGOmregnFraDato;
	}

}
