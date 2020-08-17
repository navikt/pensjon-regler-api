 package no.nav.service.pensjon.regler.to;

import no.stelvio.common.transferobject.ServiceResponse;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.Trygdetid;

/**
 * Dataoverføringsobjekt, returdata, for tjenesten fastsettTrygdetid.
 *
 * @author Lars Hartvigsen (Decisive), PK-12705
 */
public class TrygdetidResponse extends ServiceResponse{

	private static final long serialVersionUID = 8672582253263038028L;
	
	/**
	 * Fastsatt trygdetid.
	 */
	Trygdetid trygdetid;

	/**
	 * Fastsatt trygdetid for AP2016 iht. kapittel 20 og AP2025.
	 */
	Trygdetid trygdetidKapittel20;

    /**
     * Fastsatt trygdetid for annet uføretidspunkt.
     */
    Trygdetid trygdetidAlternativ;

	/**
	 * Pakkseddel for beregningene.
	 */
	private Pakkseddel pakkseddel  = new Pakkseddel(true, true);

	public TrygdetidResponse(Trygdetid trygdetid) {
		super();
		this.trygdetid = trygdetid;
	}

	public TrygdetidResponse() {
		super();
	}

	public Trygdetid getTrygdetid() {
		return trygdetid;
	}

	public void setTrygdetid(Trygdetid trygdetid) {
		this.trygdetid = trygdetid;
	}

	public Pakkseddel getPakkseddel() {
		return pakkseddel;
	}

	public void setPakkseddel(Pakkseddel pakkseddel) {
		this.pakkseddel = pakkseddel;
	}

	public Trygdetid getTrygdetidKapittel20() {
		return trygdetidKapittel20;
	}

	public void setTrygdetidKapittel20(Trygdetid trygdetidKapittel20) {
		this.trygdetidKapittel20 = trygdetidKapittel20;
	}

    public Trygdetid getTrygdetidAlternativ() {
        return trygdetidAlternativ;
    }

    public void setTrygdetidAlternativ(Trygdetid trygdetidAlternativ) {
        this.trygdetidAlternativ = trygdetidAlternativ;
    }
}
