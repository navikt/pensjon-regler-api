package no.nav.service.pensjon.regler.to;

import java.util.Date;

import no.nav.domain.pensjon.regler.beregning2011.BeregningsResultatAfpPrivat;

public class RegulerAfpPrivatBeregningRequest extends ServiceRequest {

	private Date virkFom;
	private Date virkFomAfpFrivatUttak;
	private BeregningsResultatAfpPrivat beregningsResultat;
	
}
