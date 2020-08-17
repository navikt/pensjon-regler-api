package no.nav.service.pensjon.regler.to;

import java.util.Date;

import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.stelvio.common.transferobject.ServiceRequest;

public class VilkarsprovAlderpensjonForsteUttakRequest extends ServiceRequest {
	private static final long serialVersionUID = -4360124186327648054L;

	private Kravhode kravhode;
	private Date fom;
	private int uttaksgrad;
	private double ft;
	private double ft67Soker;
	private double ft67SokerMinus1;
	private double ft67Virk;
	private double ft67VirkMinus1;

	public VilkarsprovAlderpensjonForsteUttakRequest() {
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
	public double getFt() {
		return ft;
	}
	public void setFt(double ft) {
		this.ft = ft;
	}

	public double getFt67Soker() {
		return ft67Soker;
	}
	public void setFt67Soker(double ft67Soker) {
		this.ft67Soker = ft67Soker;
	}
	public double getFt67SokerMinus1() {
		return ft67SokerMinus1;
	}
	public void setFt67SokerMinus1(double ft67SokerMinus1) {
		this.ft67SokerMinus1 = ft67SokerMinus1;
	}
	public double getFt67Virk() {
		return ft67Virk;
	}
	public void setFt67Virk(double ft67Virk) {
		this.ft67Virk = ft67Virk;
	}
	public double getFt67VirkMinus1() {
		return ft67VirkMinus1;
	}
	public void setFt67VirkMinus1(double ft67VirkMinus1) {
		this.ft67VirkMinus1 = ft67VirkMinus1;
	}
	public Kravhode getKravHode() {
		return kravhode;
	}
	public void setKravHode(Kravhode kravhode) {
		this.kravhode = kravhode;
	}
	public int getUttaksgrad() {
		return uttaksgrad;
	}
	public void setUttaksgrad(int uttaksgrad) {
		this.uttaksgrad = uttaksgrad;
	}

}
