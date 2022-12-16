package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.Date;


/**
 * Denne klassen inneholder informasjon om TP-ordningers uf�repensjonsgrunnlag. Dette er manuelt registrerte data og ikke hentet fra TP-registeret eller andre eksterne kilder.
 * 
 * @author Frederik R�nnevig (Decisive) - PK-35111, PKKAMEL-4656
 */
 
 public class AfpTpoUpGrunnlag implements Serializable {
 
    /**
     * Bel�p som skal benyttes i AFP-beregning dersom bruker har hatt uf�repensjon fra TPO
     */
	private int belop;
 
 
	/**
	* Dato som bel�pet ovenfor var gyldig
	*/
	private Date virkFom;


	
}
