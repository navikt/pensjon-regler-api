package no.nav.pensjon.regler.to;

import java.util.Date;


import no.nav.pensjon.regler.domain.kode.SatsTypeCti;

public class HentGyldigSatsRequest extends ServiceRequest {

	private static final long serialVersionUID = -5436561080261077729L;
	
	private Date fomDato;
	private Date tomDato;
	
	private SatsTypeCti satsType;

    private boolean beregnetSomGift;
    private boolean forsorgerEPSOver60;
    private boolean ungUfor;

    public HentGyldigSatsRequest() {
        super();
    }

   public Date getFomDato() {
		return fomDato;
	}

	public void setFomDato(Date fomDato) {
		this.fomDato = fomDato;
	}

	public Date getTomDato() {
		return tomDato;
	}

	public void setTomDato(Date tomDato) {
		this.tomDato = tomDato;
	}

	public SatsTypeCti getSatsType() {
		return satsType;
	}

	public void setSatsType(SatsTypeCti satsType) {
		this.satsType = satsType;
	}

    public boolean isBeregnetSomGift() {
        return beregnetSomGift;
    }

    public void setBeregnetSomGift(boolean beregnetSomGift) {
        this.beregnetSomGift = beregnetSomGift;
    }

    public boolean isForsorgerEPSOver60() {
        return forsorgerEPSOver60;
    }

    public void setForsorgerEPSOver60(boolean forsorgerEPSOver60) {
        this.forsorgerEPSOver60 = forsorgerEPSOver60;
    }

    public boolean isUngUfor() {
        return ungUfor;
    }

    public void setUngUfor(boolean ungUfor) {
        this.ungUfor = ungUfor;
    }

}
