package no.nav.pensjon.regler.to;

import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat;

public class RegulerBeregning2011Response extends ServiceResponse {
	private static final long serialVersionUID = 8036957107632799916L;
	
	private AbstraktBeregningsResultat beregningsResultat;
	private Pakkseddel pakkseddel;
	
	public RegulerBeregning2011Response() {
		super();
	}

	public AbstraktBeregningsResultat getBeregningsResultat() {
		return beregningsResultat;
	}

	public void setBeregningsResultat(AbstraktBeregningsResultat beregningsResultat) {
		this.beregningsResultat = beregningsResultat;
	}

	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}
	
}
