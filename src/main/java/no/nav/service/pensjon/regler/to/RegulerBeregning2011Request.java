package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Date;

import no.nav.domain.pensjon.regler.beregning2011.AbstraktBeregningsResultat;
import no.nav.domain.pensjon.regler.beregning2011.AfpLivsvarig;
import no.nav.domain.pensjon.regler.grunnlag.DelingstallUtvalg;
import no.nav.domain.pensjon.regler.grunnlag.ForholdstallUtvalg;
import no.nav.domain.pensjon.regler.grunnlag.Uttaksgrad;

public class RegulerBeregning2011Request extends ServiceRequest {
	private Date virkFom;
	private AbstraktBeregningsResultat beregningsResultat;
	private AfpLivsvarig afpLivsvarig;
	private ArrayList<Uttaksgrad> uttaksgradListe;
	private Date fodselsdato;
	private ForholdstallUtvalg forholdstallUtvalg;
	private DelingstallUtvalg delingstallUtvalg;
}
