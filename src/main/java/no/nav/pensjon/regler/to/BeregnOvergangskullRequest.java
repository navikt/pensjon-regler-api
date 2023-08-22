package no.nav.pensjon.regler.to;

import java.util.Date;
import java.util.Vector;

import no.nav.pensjon.regler.domain.beregning2011.SisteAldersberegning2011;
import no.nav.pensjon.regler.domain.grunnlag.DelingstallUtvalg;
import no.nav.pensjon.regler.domain.grunnlag.ForholdstallUtvalg;
import no.nav.pensjon.regler.domain.grunnlag.InfoPavirkendeYtelse;
import no.nav.pensjon.regler.domain.kode.ResultatTypeCti;
import no.nav.pensjon.regler.domain.krav.Kravhode;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;

public class BeregnOvergangskullRequest extends ServiceRequest {
	
	private static final long serialVersionUID = 8379245942724340959L;

	private Kravhode kravhode;
	private Vector<VilkarsVedtak> vilkarsvedtakListe ;
	private InfoPavirkendeYtelse infoPavirkendeYtelse;
	private DelingstallUtvalg delingstallUtvalg;
	private ForholdstallUtvalg forholdstallUtvalg;
	private Date virkFom;
	private SisteAldersberegning2011 sisteAldersBeregning;
	private double nettoUPellerGJP;
	private ResultatTypeCti nettoUPellerGJPresultatType;
	private boolean epsMottarPensjon;
	
	public BeregnOvergangskullRequest() {
		super();
		vilkarsvedtakListe = new Vector<VilkarsVedtak>();
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

	public SisteAldersberegning2011 getSisteAldersBeregning() {
		return sisteAldersBeregning;
	}

	public void setSisteAldersBeregning(
			SisteAldersberegning2011 sisteAldersBeregning) {
		this.sisteAldersBeregning = sisteAldersBeregning;
	}

	public Kravhode getKravhode() {
		return kravhode;
	}

	public void setKravhode(Kravhode kravhode) {
		this.kravhode = kravhode;
	}

	public double getNettoUPellerGJP() {
		return nettoUPellerGJP;
	}

	public void setNettoUPellerGJP(double nettoUPellerGJP) {
		this.nettoUPellerGJP = nettoUPellerGJP;
	}

	public ResultatTypeCti getNettoUPellerGJPresultatType() {
		return nettoUPellerGJPresultatType;
	}

	public void setNettoUPellerGJPresultatType(
			ResultatTypeCti nettoUPellerGJPresultatType) {
		this.nettoUPellerGJPresultatType = nettoUPellerGJPresultatType;
	}

	public Vector<VilkarsVedtak> getVilkarsvedtakListe() {
		return vilkarsvedtakListe;
	}

	public void setVilkarsvedtakListe(Vector<VilkarsVedtak> vilkarsvedtakListe) {
		this.vilkarsvedtakListe = vilkarsvedtakListe;
	}

	public Date getVirkFom() {
		return virkFom;
	}

	public void setVirkFom(Date virkFom) {
		this.virkFom = virkFom;
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
	
}
