 package no.nav.service.pensjon.regler.to;


import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.Trygdetid;

/**
 * Dataoverføringsobjekt, returdata, for tjenesten fastsettTrygdetid.
 *
 * @author Lars Hartvigsen (Decisive), PK-12705
 */
public class TrygdetidResponse extends ServiceResponse{

	
	
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


}
