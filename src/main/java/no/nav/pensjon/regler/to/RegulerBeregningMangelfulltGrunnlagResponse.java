package no.nav.pensjon.regler.to;

import java.util.Date;

import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.beregning.Beregning;
import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat;

public class RegulerBeregningMangelfulltGrunnlagResponse extends ServiceResponse  {
	private static final long serialVersionUID = 1245764083517519824L;
	
	private Pakkseddel pakkseddel;
	private Beregning beregning1967;
	private AbstraktBeregningsResultat beregningsResultat2011;
	
	public RegulerBeregningMangelfulltGrunnlagResponse() {
		super();
	}

	public RegulerBeregningMangelfulltGrunnlagResponse(
			Date virkFom,
			Beregning beregning1967,
			AbstraktBeregningsResultat beregningsResultat2011) {
		this();
		this.setBeregning1967(beregning1967);
		this.setBeregningsResultat2011(beregningsResultat2011);
	}

	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}

	public void setBeregning1967(Beregning beregning1967) {
		this.beregning1967 = beregning1967;
	}

	public Beregning getBeregning1967() {
		return beregning1967;
	}

	public void setBeregningsResultat2011(AbstraktBeregningsResultat beregningsResultat2011) {
		this.beregningsResultat2011 = beregningsResultat2011;
	}

	public AbstraktBeregningsResultat getBeregningsResultat2011() {
		return beregningsResultat2011;
	}

}
