package no.nav.service.pensjon.regler.to;

import java.util.Date;

import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.beregning2011.AbstraktBeregningsResultat;

public class RegulerBeregningMangelfulltGrunnlagRequest extends ServiceRequest  {
	private static final long serialVersionUID = -1436468885395731897L;

	private Date virkFom;
	private Beregning beregning1967;
	private AbstraktBeregningsResultat beregningsResultat2011;

	public RegulerBeregningMangelfulltGrunnlagRequest() {
		super();
	}

	public RegulerBeregningMangelfulltGrunnlagRequest(
			Date virkFom,
			Beregning beregning1967,
			AbstraktBeregningsResultat beregningsResultat2011) {
		this();
		this.virkFom = virkFom;
		this.setBeregning1967(beregning1967);
		this.setBeregningsResultat2011(beregningsResultat2011);

	}

	public Date getVirkFom() {
		return virkFom;
	}

	public void setVirkFom(Date virkFom) {
		this.virkFom = virkFom;
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
