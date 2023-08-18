package no.nav.pensjon.regler.to;

import java.util.Date;

import no.nav.pensjon.regler.domain.krav.Kravhode;

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
