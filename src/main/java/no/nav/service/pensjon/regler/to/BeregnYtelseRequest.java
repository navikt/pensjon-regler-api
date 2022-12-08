package no.nav.service.pensjon.regler.to;

import java.util.Date;
import java.util.Vector;

import no.nav.domain.pensjon.regler.grunnlag.InfoPavirkendeYtelse;
import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

public class BeregnYtelseRequest extends ServiceRequest {


	private Kravhode kravhode;

	private Vector<VilkarsVedtak> vilkarsvedtaksliste = new Vector<VilkarsVedtak>();

	private Date fom;

	private Date tom;

	private boolean ektefelleMottarPensjon;

	private boolean beregnForsorgingstillegg;

	private boolean beregnInstitusjonsopphold;
	
	private InfoPavirkendeYtelse infoPavirkendeYtelse;

	/**
	 * Ikke brukt i PREG
	 */
	private Date vedtakVirkFom;


}
