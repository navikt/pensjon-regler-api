package no.nav.pensjon.regler.to;

import java.util.Date;
import java.util.Vector;

import no.nav.pensjon.regler.domain.gomregning.KravFaktoromregningGrunnlag;

public class FaktoromregnInntektBatchRequest extends ServiceRequest {

	private static final long serialVersionUID = 1783975436295339903L;

	/**
	 * Dato for når gammel regulering gjaldt.
	 */
	private Date gammelReguleringGjaldtDato;

	/**
	 * Ny dato det skal omregnes for.
	 */
	private Date nyReguleringOmregnFraDato;

	/**
	 * Liste av grunnlag for faktoromregning.
	 */
	private Vector<KravFaktoromregningGrunnlag> kravFaktoromregningGrunnlagListe = new Vector<KravFaktoromregningGrunnlag>();

	/**
	 * Angir om tjenestekallet er en batch jobb eller ikke.
	 */
	private boolean automaticJob;

	public FaktoromregnInntektBatchRequest() {
		kravFaktoromregningGrunnlagListe = new Vector<KravFaktoromregningGrunnlag>();
	}

	public Date getGammelReguleringGjaldtDato() {
		return gammelReguleringGjaldtDato;
	}

	public void setGammelReguleringGjaldtDato(Date gammelReguleringGjaldtDato) {
		this.gammelReguleringGjaldtDato = gammelReguleringGjaldtDato;
	}

	public Date getNyReguleringOmregnFraDato() {
		return nyReguleringOmregnFraDato;
	}

	public void setNyReguleringOmregnFraDato(Date nyReguleringOmregnFraDato) {
		this.nyReguleringOmregnFraDato = nyReguleringOmregnFraDato;
	}

	public Vector<KravFaktoromregningGrunnlag> getKravFaktoromregningGrunnlagListe() {
		return kravFaktoromregningGrunnlagListe;
	}

	public KravFaktoromregningGrunnlag[] retrieveKravFaktoromregningGrunnlagListe() {
		return (KravFaktoromregningGrunnlag[]) kravFaktoromregningGrunnlagListe
				.toArray(new KravFaktoromregningGrunnlag[0]);
	}

	public void setKravFaktoromregningGrunnlagListe(
			Vector<KravFaktoromregningGrunnlag> kravFaktoromregningGrunnlagListe) {
		this.kravFaktoromregningGrunnlagListe = kravFaktoromregningGrunnlagListe;
	}

	public boolean isAutomaticJob() {
		return automaticJob;
	}

	public void setAutomaticJob(boolean automaticJob) {
		this.automaticJob = automaticJob;
	}
}
