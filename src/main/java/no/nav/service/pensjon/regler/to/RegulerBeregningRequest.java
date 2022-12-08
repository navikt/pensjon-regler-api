package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Date;

import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.grunnlag.Persongrunnlag;
import no.nav.domain.pensjon.regler.grunnlag.Uttaksgrad;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

public class RegulerBeregningRequest extends ServiceRequest {

	private Beregning beregning1967;
	private Date virkFom;
	private ArrayList<Uttaksgrad> uttaksgradListe;
	private ArrayList<VilkarsVedtak> brukersVilkarsvedtakListe;
	private Persongrunnlag sokersPersongrunnlag;
	private Persongrunnlag epsPersongrunnlag;
	

}
