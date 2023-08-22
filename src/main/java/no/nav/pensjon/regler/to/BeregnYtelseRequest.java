package no.nav.pensjon.regler.to;

import java.util.Date;
import java.util.Vector;

import no.nav.pensjon.regler.domain.grunnlag.InfoPavirkendeYtelse;
import no.nav.pensjon.regler.domain.krav.Kravhode;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;

public class BeregnYtelseRequest extends ServiceRequest {

	private static final long serialVersionUID = -8688003227599222484L;

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

	public BeregnYtelseRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BeregnYtelseRequest(Kravhode kravhode, Vector<VilkarsVedtak> vedtaksliste, Date fom, Date tom,
			Date vedtakVirkFom, boolean ektefelleMottarPensjon, boolean beregnForsorgingstillegg,
			boolean beregnInstitusjonsopphold, InfoPavirkendeYtelse infoPavirkendeYtelse) {
		this.kravhode = kravhode;
		this.vilkarsvedtaksliste = vedtaksliste;
		this.fom = fom;
		this.tom = tom;
		this.vedtakVirkFom = vedtakVirkFom;
		this.ektefelleMottarPensjon = ektefelleMottarPensjon;
		this.beregnForsorgingstillegg = beregnForsorgingstillegg;
		this.beregnInstitusjonsopphold = beregnInstitusjonsopphold;
	}

	public Kravhode getKravhode() {
		return kravhode;
	}

	public void setKravhode(Kravhode kravhode) {
		this.kravhode = kravhode;
	}

	public Vector<VilkarsVedtak> getVedtaksliste() {
		return vilkarsvedtaksliste;
	}

	public void setVedtaksliste(Vector<VilkarsVedtak> vedtaksliste) {
		this.vilkarsvedtaksliste = vedtaksliste;
	}

	public Date getFom() {
		return fom;
	}

	public void setFom(Date fom) {
		this.fom = fom;
	}

	public Date getTom() {
		return tom;
	}

	public void setTom(Date tom) {
		this.tom = tom;
	}

	public Date getVedtakVirkFom() {
		return vedtakVirkFom;
	}

	public void setVedtakVirkFom(Date vedtakVirkFom) {
		this.vedtakVirkFom = vedtakVirkFom;
	}

	public boolean isEktefelleMottarPensjon() {
		return ektefelleMottarPensjon;
	}

	public void setEktefelleMottarPensjon(boolean ektefelleMottarPensjon) {
		this.ektefelleMottarPensjon = ektefelleMottarPensjon;
	}

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

	public InfoPavirkendeYtelse getInfoPavirkendeYtelse() {
		return infoPavirkendeYtelse;
	}

	public void setInfoPavirkendeYtelse(InfoPavirkendeYtelse infoPavirkendeYtelse) {
		this.infoPavirkendeYtelse = infoPavirkendeYtelse;
	}

}
