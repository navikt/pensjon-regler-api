package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.stelvio.common.transferobject.ServiceResponse;

public class RevurderingYtelse1967Response extends ServiceResponse {
	private static final long serialVersionUID = 375644410497407900L;
	
	private Beregning beregning1967;
	private Beregning beregning1967TilRevurdering;
	public Beregning getBeregning1967TilRevurdering() {
		return beregning1967TilRevurdering;
	}

	public void setBeregning1967TilRevurdering(Beregning beregning1967TilRevurdering) {
		this.beregning1967TilRevurdering = beregning1967TilRevurdering;
	}

	private Pakkseddel pakkseddel;
	
	public RevurderingYtelse1967Response() {
		super();
	}

	public Beregning getBeregning1967() {
		return beregning1967;
	}

	public void setBeregning1967(Beregning beregning1967) {
		this.beregning1967 = beregning1967;
	}

	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}
	
}
