package no.nav.service.pensjon.regler.to;

import java.util.Date;

import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.stelvio.common.transferobject.ServiceRequest;

public class VilkarsprovEktefelletillegg2011Request extends ServiceRequest {
	private static final long serialVersionUID = 6903472554119659759L;

	private Kravhode kravhode;
	private Date fom;
	private Date tom;

	public VilkarsprovEktefelletillegg2011Request() {
		super();
	}

	public Kravhode getKravhode() {
		return kravhode;
	}

	public void setKravhode(Kravhode kravhode) {
		this.kravhode = kravhode;
	}

	public Date getFom() {
		return fom;
	}

	public void setFom(Date fom) {
		this.fom = fom;
	}

	public Date getTom() {
		return tom;
	}

	public void setTom(Date tom) {
		this.tom = tom;
	}
}
