package no.nav.pensjon.regler.to;

import java.util.Date;
import java.util.List;
import java.util.Vector;
import no.nav.pensjon.regler.domain.beregning2011.AfpLivsvarig;
import no.nav.pensjon.regler.domain.grunnlag.ForholdstallUtvalg;
import no.nav.pensjon.regler.domain.grunnlag.InfoPavirkendeYtelse;
import no.nav.pensjon.regler.domain.krav.Kravhode;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;

public class BeregnAlderspensjon2011ForsteUttakRequest extends ServiceRequest {
	private static final long serialVersionUID = -6939482763082651152L;
	private Kravhode kravhode;
	private List<VilkarsVedtak> vilkarsvedtakListe = new Vector<VilkarsVedtak>();
	private InfoPavirkendeYtelse infoPavirkendeYtelse;
	private Date virkFom;
	private Date virkTom;
	private ForholdstallUtvalg forholdstallUtvalg;
	private boolean ektefellenMottarPensjon;
	private AfpLivsvarig afpLivsvarig;

	public BeregnAlderspensjon2011ForsteUttakRequest() {
	    super();
	}

	public BeregnAlderspensjon2011ForsteUttakRequest(Kravhode kravhode, List<VilkarsVedtak> vilkarsVedtak, InfoPavirkendeYtelse infoPavirkendeYtelse, Date virkFom, Date virkTom, ForholdstallUtvalg forholdstallUtvalg, boolean ektefellenMottarPensjon) {
		this.kravhode = kravhode;
		this.vilkarsvedtakListe = vilkarsVedtak;
		this.infoPavirkendeYtelse = infoPavirkendeYtelse;
		this.virkFom = virkFom;
		this.virkTom = virkTom;
		this.forholdstallUtvalg = forholdstallUtvalg;
		this.ektefellenMottarPensjon = ektefellenMottarPensjon;
	}

	public boolean isEktefellenMottarPensjon() {
		return ektefellenMottarPensjon;
	}

	public void setEktefellenMottarPensjon(boolean ektefellenMottarPensjon) {
		this.ektefellenMottarPensjon = ektefellenMottarPensjon;
	}

	public ForholdstallUtvalg getForholdstallUtvalg() {
		return forholdstallUtvalg;
	}

	public void setForholdstallUtvalg(ForholdstallUtvalg forholdstallUtvalg) {
		this.forholdstallUtvalg = forholdstallUtvalg;
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

	public Date getVirkFom() {
		return virkFom;
	}

	public void setVirkFom(Date virkFom) {
		this.virkFom = virkFom;
	}

	public Date getVirkTom() {
		return virkTom;
	}

	public void setVirkTom(Date virkTom) {
		this.virkTom = virkTom;
	}

	public InfoPavirkendeYtelse getInfoPavirkendeYtelse() {
		return infoPavirkendeYtelse;
	}

	public void setInfoPavirkendeYtelse(InfoPavirkendeYtelse infoPavirkendeYtelse) {
		this.infoPavirkendeYtelse = infoPavirkendeYtelse;
	}

	public AfpLivsvarig getAfpLivsvarig() {
		return afpLivsvarig;
	}

	public void setAfpLivsvarig(AfpLivsvarig afpLivsvarig) {
		this.afpLivsvarig = afpLivsvarig;
	}
	
}
