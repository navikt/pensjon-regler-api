package no.nav.service.pensjon.regler.to;

import java.util.Date;

import no.nav.domain.pensjon.regler.simulering.Simulering;

public class SimuleringRequest extends ServiceRequest{

	private Simulering simulering;
	private Date fom;
	private boolean ektefelleMottarPensjon;

	private boolean beregnForsorgingstillegg;

	private boolean beregnInstitusjonsopphold;

}
