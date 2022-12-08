package no.nav.service.pensjon.regler.to;

import java.util.Vector;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning2011.Regelendring;

/**
 * Responseobjekt for BEF2001 Identifiser regelendringer.
 * 
 * @author and2812
 *
 */
public class IdentifiserRegelendringerResponse extends ServiceResponse {

	/**
	 * Generated serial version UID.
	 */

	/**
	 * Listen av regel- og satsendringer som tjenesten fant for tidsrommet og input den ble kalt med.
	 * Listen er ikke sortert på dato, men hver dato i listen er unik. 
	 */
	private Vector<Regelendring> regelendringListe = new Vector<Regelendring>();
	/**
	 * Pakkseddel som indikerer om det oppstod feil ved tjenestekallet.
	 */
	private Pakkseddel pakkseddel;

	
}
