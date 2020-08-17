package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Date;

import no.nav.domain.pensjon.regler.beregning2011.AfpLivsvarig;
import no.nav.domain.pensjon.regler.beregning2011.SisteAldersberegning2011;
import no.nav.domain.pensjon.regler.grunnlag.DelingstallUtvalg;
import no.nav.domain.pensjon.regler.grunnlag.ForholdstallUtvalg;
import no.nav.domain.pensjon.regler.grunnlag.GarantitilleggsbeholdningGrunnlag;
import no.nav.domain.pensjon.regler.grunnlag.InfoPavirkendeYtelse;
import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;
import no.stelvio.common.transferobject.ServiceRequest;

public class RevurderingAlderspensjon2025Request extends ServiceRequest {

	private static final long serialVersionUID = 8379245942724320919L;

	private Kravhode kravhode;
	private ArrayList<VilkarsVedtak> vilkarsvedtakListe ;
	private InfoPavirkendeYtelse infoPavirkendeYtelse;
	private boolean epsMottarPensjon;
	private ForholdstallUtvalg forholdstallUtvalg;
	private DelingstallUtvalg delingstallUtvalg;
	private Date virkFom;
	private SisteAldersberegning2011 sisteAldersBeregning2011;
	private AfpLivsvarig afpLivsvarig;
	private GarantitilleggsbeholdningGrunnlag garantitilleggsbeholdningGrunnlag;

	public RevurderingAlderspensjon2025Request() {
		super();
		vilkarsvedtakListe = new ArrayList<VilkarsVedtak>();
	}
	
	public RevurderingAlderspensjon2025Request(Kravhode kravhode, ArrayList<VilkarsVedtak> vilkarsvedtakListe, InfoPavirkendeYtelse infoPavirkendeYtelse, 
			boolean epsMottarPensjon, ForholdstallUtvalg forholdstallUtvalg, DelingstallUtvalg delingstallUtvalg, Date virkFom, SisteAldersberegning2011 sisteAldersBeregning2011, AfpLivsvarig afpLivsvarig, GarantitilleggsbeholdningGrunnlag grunnlagForGarantiTillegg) {
		this();
		this.kravhode = kravhode;
		this.vilkarsvedtakListe = vilkarsvedtakListe;
		this.infoPavirkendeYtelse = infoPavirkendeYtelse;
		this.epsMottarPensjon = epsMottarPensjon;
		this.forholdstallUtvalg = forholdstallUtvalg;
		this.delingstallUtvalg = delingstallUtvalg;
		this.virkFom = virkFom;
		this.sisteAldersBeregning2011 = sisteAldersBeregning2011;
		this.afpLivsvarig = afpLivsvarig;
		this.garantitilleggsbeholdningGrunnlag = grunnlagForGarantiTillegg;
	}
	
	public Kravhode getKravhode() {
		return kravhode;
	}
	public void setKravhode(Kravhode kravhode) {
		this.kravhode = kravhode;
	}
	public ArrayList<VilkarsVedtak> getVilkarsvedtakListe() {
		return vilkarsvedtakListe;
	}
	public void setVilkarsvedtakListe(ArrayList<VilkarsVedtak> vilkarsvedtakListe) {
		this.vilkarsvedtakListe = vilkarsvedtakListe;
	}
	public InfoPavirkendeYtelse getInfoPavirkendeYtelse() {
		return infoPavirkendeYtelse;
	}
	public void setInfoPavirkendeYtelse(InfoPavirkendeYtelse infoPavirkendeYtelse) {
		this.infoPavirkendeYtelse = infoPavirkendeYtelse;
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
	public DelingstallUtvalg getDelingstallUtvalg() {
		return delingstallUtvalg;
	}
	public void setDelingstallUtvalg(DelingstallUtvalg delingstallUtvalg) {
		this.delingstallUtvalg = delingstallUtvalg;
	}
	public Date getVirkFom() {
		return virkFom;
	}
	public void setVirkFom(Date virkFom) {
		this.virkFom = virkFom;
	}
	public SisteAldersberegning2011 getSisteAldersBeregning2011() {
		return sisteAldersBeregning2011;
	}
	public void setSisteAldersBeregning2011(
			SisteAldersberegning2011 sisteAldersBeregning2011) {
		this.sisteAldersBeregning2011 = sisteAldersBeregning2011;
	}
	public AfpLivsvarig getAfpLivsvarig() {
		return afpLivsvarig;
	}
	public void setAfpLivsvarig(AfpLivsvarig afpLivsvarig) {
		this.afpLivsvarig = afpLivsvarig;
	}

	public GarantitilleggsbeholdningGrunnlag getGarantitilleggsbeholdningGrunnlag() {
		return garantitilleggsbeholdningGrunnlag;
	}

	public void setGarantitilleggsbeholdningGrunnlag(
			GarantitilleggsbeholdningGrunnlag garantitilleggsbeholdningGrunnlag) {
		this.garantitilleggsbeholdningGrunnlag = garantitilleggsbeholdningGrunnlag;
	}
}
