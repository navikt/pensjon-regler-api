package no.nav.service.pensjon.regler.to;

import java.util.Date;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.beregning2011.AbstraktBeregningsResultat;

public class RegulerBeregningMangelfulltGrunnlagResponse extends ServiceResponse  {

	private Pakkseddel pakkseddel;
	private Beregning beregning1967;
	private AbstraktBeregningsResultat beregningsResultat2011;

}
