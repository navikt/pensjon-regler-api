package no.nav.pensjon.regler.domain.grunnlag;

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
	
	
	
	public void setBelop (int belop) {
		this.belop = belop;
	}

	public int getBelop() {
	
		return belop;
	}
	
		
	public void setVirkFom (Date virkFom) {
		this.virkFom = virkFom;
	}

	public Date getVirkFom() {
	
		return virkFom;
	}
	
	/**
	* Default constructor
	*/
	public AfpTpoUpGrunnlag() {
		super();	
	}

	
	 /**
     * Copy Constructor
     * 
     * @param AfpTpoUpGrunnlag a <code>AfpTpoUpGrunnlag</code> object
     */
	
	public AfpTpoUpGrunnlag(AfpTpoUpGrunnlag AfpTpoUpGrunnlag) {
	
		belop = AfpTpoUpGrunnlag.belop;
		virkFom = AfpTpoUpGrunnlag.virkFom;
	
	}
	

	
}
