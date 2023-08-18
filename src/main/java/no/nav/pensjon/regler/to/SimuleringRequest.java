package no.nav.pensjon.regler.to;

import java.util.Date;

import no.nav.pensjon.regler.domain.simulering.Simulering;

public class SimuleringRequest extends ServiceRequest{
	/**
	 *
	 */
	private static final long serialVersionUID = -2061891332963623776L;
	private Simulering simulering;
	private Date fom;
	private boolean ektefelleMottarPensjon;

	private boolean beregnForsorgingstillegg;

	private boolean beregnInstitusjonsopphold;

	public boolean isBeregnForsorgingstillegg() {
		return beregnForsorgingstillegg;
	}

	public void setBeregnForsorgingstillegg(boolean beregnForsorgingstillegg) {
		this.beregnForsorgingstillegg = beregnForsorgingstillegg;
	}

	public boolean isBeregnInstitusjonsopphold() {
		return beregnInstitusjonsopphold;
	}

	public void setBeregnInstitusjonsopphold(boolean beregnInstitusjonsopphold) {
		this.beregnInstitusjonsopphold = beregnInstitusjonsopphold;
	}

	public boolean isEktefelleMottarPensjon() {
		return ektefelleMottarPensjon;
	}

	public void setEktefelleMottarPensjon(boolean ektefelleMottarPensjon) {
		this.ektefelleMottarPensjon = ektefelleMottarPensjon;
	}

	public SimuleringRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SimuleringRequest(Simulering simulering, Date fom) {
		super();
		this.simulering = simulering;
		this.fom = fom;
	}
	/**
	* Full constructor
	* @param simulering
	* @param fom
	* @param ektefelleMottarPensjon
	* @param beregnForsorgingstillegg
	* @param beregnInstitusjonsopphold
	*/
	public SimuleringRequest(Simulering simulering, Date fom, boolean ektefelleMottarPensjon,boolean beregnForsorgingstillegg, boolean beregnInstitusjonsopphold) {
		super();
		this.simulering = simulering;
		this.fom = fom;
		this.ektefelleMottarPensjon = ektefelleMottarPensjon;
		this.beregnForsorgingstillegg = beregnForsorgingstillegg;
		this.beregnInstitusjonsopphold = beregnInstitusjonsopphold;
	}
	
	public Simulering getSimulering() {
		return simulering;
	}

	public void setSimulering(Simulering simulering) {
		this.simulering = simulering;
	}
	public Date getFom() {
		return fom;
	}

	public void setFom(Date fom) {
		this.fom = fom;
	}

}
