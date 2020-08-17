package no.nav.service.pensjon.regler.to;

import java.util.Date;
import java.util.Vector;

import no.nav.domain.pensjon.regler.beregning2011.SisteAldersberegning2011;
import no.nav.domain.pensjon.regler.grunnlag.DelingstallUtvalg;
import no.nav.domain.pensjon.regler.grunnlag.ForholdstallUtvalg;
import no.nav.domain.pensjon.regler.grunnlag.InfoPavirkendeYtelse;
import no.nav.domain.pensjon.regler.kode.ResultatTypeCti;
import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;
import no.stelvio.common.transferobject.ServiceRequest;

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

	/**
	 * Read only property for vilkarsvedtakListe as array
	 * @return array of VilkarsVedtak
	 */
	public VilkarsVedtak[] getVilkarsvedtakListeAsArray() {
		return (vilkarsvedtakListe != null ? this.vilkarsvedtakListe.toArray(new VilkarsVedtak[this.vilkarsvedtakListe.size()]) : new VilkarsVedtak[0]);
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
