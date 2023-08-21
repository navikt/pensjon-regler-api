package no.nav.pensjon.regler.to;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import no.nav.pensjon.regler.domain.beregning2011.AfpLivsvarig;
import no.nav.pensjon.regler.domain.grunnlag.DelingstallUtvalg;
import no.nav.pensjon.regler.domain.grunnlag.ForholdstallUtvalg;
import no.nav.pensjon.regler.domain.grunnlag.GarantitilleggsbeholdningGrunnlag;
import no.nav.pensjon.regler.domain.grunnlag.InfoPavirkendeYtelse;
import no.nav.pensjon.regler.domain.krav.Kravhode;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;

public class BeregnAlderspensjon2025ForsteUttakRequest extends ServiceRequest {
	private static final long serialVersionUID = -8565943555158481050L;

	private Date virkFom;
	private Kravhode kravhode;
	private List<VilkarsVedtak> vilkarsvedtakListe;
	private InfoPavirkendeYtelse infoPavirkendeYtelse;
	private ForholdstallUtvalg forholdstallUtvalg;
	private DelingstallUtvalg delingstallUtvalg;
	private boolean epsMottarPensjon;
	private AfpLivsvarig afpLivsvarig;

	/**
	 * Grunnlag for beregning av garantitilleggsbeholdning.
	 * (Ref. BER3156)
	 */
	private GarantitilleggsbeholdningGrunnlag garantitilleggsbeholdningGrunnlag; 
	
	public BeregnAlderspensjon2025ForsteUttakRequest() {
		super();
		vilkarsvedtakListe = new Vector<VilkarsVedtak>();
	}

	public Date getVirkFom() {
		return virkFom;
	}

	public void setVirkFom(Date virkFom) {
		this.virkFom = virkFom;
	}

	public Kravhode getKravhode() {
		return kravhode;
	}

	public void setKravhode(Kravhode kravhode) {
		this.kravhode = kravhode;
	}

	public List<VilkarsVedtak> getVilkarsvedtakListe() {
		return vilkarsvedtakListe;
	}

	public void setVilkarsvedtakListe(List<VilkarsVedtak> vilkarsvedtakListe) {
		this.vilkarsvedtakListe = vilkarsvedtakListe;
	}

	public InfoPavirkendeYtelse getInfoPavirkendeYtelse() {
		return infoPavirkendeYtelse;
	}

	public void setInfoPavirkendeYtelse(InfoPavirkendeYtelse infoPavirkendeYtelse) {
		this.infoPavirkendeYtelse = infoPavirkendeYtelse;
	}

	public ForholdstallUtvalg getForholdstallUtvalg() {
		return forholdstallUtvalg;
	}

	public void setForholdstallUtvalg(ForholdstallUtvalg forholdstallUtvalg) {
		this.forholdstallUtvalg = forholdstallUtvalg;
	}

	public DelingstallUtvalg getDelingstallUtvalg() {
		return delingstallUtvalg;
	}

	public void setDelingstallUtvalg(DelingstallUtvalg delingstallUtvalg) {
		this.delingstallUtvalg = delingstallUtvalg;
	}

	public boolean isEpsMottarPensjon() {
		return epsMottarPensjon;
	}

	public void setEpsMottarPensjon(boolean epsMottarPensjon) {
		this.epsMottarPensjon = epsMottarPensjon;
	}

	public GarantitilleggsbeholdningGrunnlag getGarantitilleggsbeholdningGrunnlag() {
		return garantitilleggsbeholdningGrunnlag;
	}

	public void setGarantitilleggsbeholdningGrunnlag(
			GarantitilleggsbeholdningGrunnlag garantitilleggsbeholdningGrunnlag) {
		this.garantitilleggsbeholdningGrunnlag = garantitilleggsbeholdningGrunnlag;
	}

	public AfpLivsvarig getAfpLivsvarig() {
		return afpLivsvarig;
	}

	public void setAfpLivsvarig(AfpLivsvarig afpLivsvarig) {
		this.afpLivsvarig = afpLivsvarig;
	}

}
