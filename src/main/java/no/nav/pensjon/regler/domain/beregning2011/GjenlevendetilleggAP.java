package no.nav.pensjon.regler.domain.beregning2011;


import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

/**
 * GjenlevendetilleggAP
 * 
 * @author Lars Hartvigsen (Decisive), PK-20265
 * @author Magnus Bakken (Accenture), PK-20716
 */
public class GjenlevendetilleggAP extends Ytelseskomponent {

	private static final long serialVersionUID = -1277330845228200881L;

	/**
	 * Sum av GP, TP og PenT for AP2011 medregnet GJR.
	 */

	private int apKap19MedGJR;

	/**
	 * Sum av GP, TP og PenT for AP2011 uten GJR.
	 */

	private int apKap19UtenGJR;

	public GjenlevendetilleggAP() {
		super();
		ytelsekomponentType = new YtelsekomponentTypeCti("AP_GJT");
	}

	public GjenlevendetilleggAP(GjenlevendetilleggAP ytelseskomponent) {
		super(ytelseskomponent);
		this.apKap19MedGJR = ytelseskomponent.getApKap19MedGJR();
		this.apKap19UtenGJR = ytelseskomponent.getApKap19UtenGJR();
	}

	public int getApKap19MedGJR() {
		return apKap19MedGJR;
	}

	public void setApKap19MedGJR(int apKap19MedGJR) {
		this.apKap19MedGJR = apKap19MedGJR;
	}

	public int getApKap19UtenGJR() {
		return apKap19UtenGJR;
	}

	public void setApKap19UtenGJR(int apKap19UtenGJR) {
		this.apKap19UtenGJR = apKap19UtenGJR;
	}
}
