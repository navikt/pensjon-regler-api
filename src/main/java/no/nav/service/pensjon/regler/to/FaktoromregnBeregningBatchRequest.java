package no.nav.service.pensjon.regler.to;

import java.util.Date;
import java.util.Vector;

import no.nav.domain.pensjon.regler.gomregning.BeregningerTilFaktoromregningGrunnlag;

public class FaktoromregnBeregningBatchRequest  extends ServiceRequest {

	private Date gammelGGjaldtDato;
	private Date nyGOmregnFraDato;
	private Vector<BeregningerTilFaktoromregningGrunnlag> beregningerTilFaktoromregningGrunnlagListe = new Vector<BeregningerTilFaktoromregningGrunnlag>();


}
