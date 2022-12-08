package no.nav.service.pensjon.regler.to;

import java.util.Date;
import java.util.Vector;

import no.nav.domain.pensjon.regler.gomregning.KravFaktoromregningGrunnlag;

public class FaktoromregnInntektBatchRequest extends ServiceRequest {


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
}
