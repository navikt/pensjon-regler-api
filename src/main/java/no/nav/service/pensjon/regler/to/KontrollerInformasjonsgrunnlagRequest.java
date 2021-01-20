package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.krav.Kravhode;

public class KontrollerInformasjonsgrunnlagRequest extends ServiceRequest {

	private static final long serialVersionUID = 8730443634418683019L;

	private Kravhode kravhode;

	public KontrollerInformasjonsgrunnlagRequest(Kravhode kravhode) {
		super();
		this.kravhode = kravhode;
	}
	public KontrollerInformasjonsgrunnlagRequest() {
		super();
	}
	public Kravhode getKravhode() {
		return kravhode;
	}
	public void setKravhode(Kravhode kravhode) {
		this.kravhode = kravhode;
	}


}
