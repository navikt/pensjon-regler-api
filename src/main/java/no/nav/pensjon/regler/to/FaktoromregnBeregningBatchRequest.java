package no.nav.pensjon.regler.to;

import java.util.Date;
import java.util.Vector;

import no.nav.pensjon.regler.domain.gomregning.BeregningerTilFaktoromregningGrunnlag;

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
