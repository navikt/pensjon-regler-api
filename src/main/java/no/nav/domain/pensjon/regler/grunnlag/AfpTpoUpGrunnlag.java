package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.Date;


/**
 * Denne klassen inneholder informasjon om TP-ordningers uførepensjonsgrunnlag. Dette er manuelt registrerte data og ikke hentet fra TP-registeret eller andre eksterne kilder.
 * 
 * @author Frederik Rønnevig (Decisive) - PK-35111, PKKAMEL-4656
 */
 
 public class AfpTpoUpGrunnlag implements Serializable {
 
    /**
     * Beløp som skal benyttes i AFP-beregning dersom bruker har hatt uførepensjon fra TPO
     */
	private int belop;
 
 
	/**
	* Dato som beløpet ovenfor var gyldig
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
