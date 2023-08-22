package no.nav.pensjon.regler.to;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import no.nav.pensjon.regler.domain.beregning2011.AfpLivsvarig;
import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2016;
import no.nav.pensjon.regler.domain.grunnlag.DelingstallUtvalg;
import no.nav.pensjon.regler.domain.grunnlag.ForholdstallUtvalg;
import no.nav.pensjon.regler.domain.grunnlag.GarantitilleggsbeholdningGrunnlag;
import no.nav.pensjon.regler.domain.grunnlag.InfoPavirkendeYtelse;
import no.nav.pensjon.regler.domain.krav.Kravhode;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;

public class RevurderingAlderspensjon2016Request extends ServiceRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4699755578860073692L;
	private Kravhode kravhode;
	private List<VilkarsVedtak> vilkarsvedtakListe ;
	private InfoPavirkendeYtelse infoPavirkendeYtelse;
	private boolean epsMottarPensjon;
	private ForholdstallUtvalg forholdstallUtvalg;
	private DelingstallUtvalg delingstallUtvalg;
	private Date virkFom;
	private SisteAldersberegning2016 forrigeAldersBeregning;
	private AfpLivsvarig afpLivsvarig;
	/**
	 * Grunnlag for beregning av garantitilleggsbeholdning.
	 * (Ref. BER3156)
	 */
	private GarantitilleggsbeholdningGrunnlag garantitilleggsbeholdningGrunnlag; 
	
	public RevurderingAlderspensjon2016Request() {
		super();
		vilkarsvedtakListe = new Vector<VilkarsVedtak>();
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
	public ForholdstallUtvalg getForholdstallUtvalg() {
		return forholdstallUtvalg;
	}
	public void setForholdstallUtvalg(ForholdstallUtvalg forholdstallUtvalg) {
		this.forholdstallUtvalg = forholdstallUtvalg;
	}
	public SisteAldersberegning2016 getForrigeAldersBeregning() {
		return forrigeAldersBeregning;
	}
	public void setForrigeAldersBeregning(
			SisteAldersberegning2016 forrigeAldersBeregning) {
		this.forrigeAldersBeregning = forrigeAldersBeregning;
	}
	public InfoPavirkendeYtelse getInfoPavirkendeYtelse() {
		return infoPavirkendeYtelse;
	}
	public void setInfoPavirkendeYtelse(InfoPavirkendeYtelse infoPavirkendeYtelse) {
		this.infoPavirkendeYtelse = infoPavirkendeYtelse;
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
	

}
