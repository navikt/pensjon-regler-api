package no.nav.service.pensjon.regler.to;

import java.util.Vector;

import no.nav.domain.pensjon.regler.grunnlag.PersonOpptjeningsgrunnlag;

public class BeregnPoengtallBatchResponse extends ServiceResponse{
	private Vector<PersonOpptjeningsgrunnlag> personOpptjeningsgrunnlagListe = new Vector<PersonOpptjeningsgrunnlag>();

}
