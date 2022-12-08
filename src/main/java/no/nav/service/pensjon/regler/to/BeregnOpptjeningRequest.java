package no.nav.service.pensjon.regler.to;

import java.util.Date;

import no.nav.domain.pensjon.regler.grunnlag.Pensjonsbeholdning;
import no.nav.domain.pensjon.regler.grunnlag.Persongrunnlag;
/**
 * Dataoverføringsobjekt for tjenesten beregnOpptjening.
 */
public class BeregnOpptjeningRequest extends ServiceRequest {
	private Date beholdningTom;
	private Persongrunnlag persongrunnlag;
	private Pensjonsbeholdning beholdning;


}
